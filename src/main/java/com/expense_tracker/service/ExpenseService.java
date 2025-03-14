package com.expense_tracker.service;

import com.expense_tracker.dto.ExpenseDTO;
import com.expense_tracker.model.Expense;
import com.expense_tracker.model.User;
import com.expense_tracker.repository.ExpenseRepository;
import com.expense_tracker.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;

    public ExpenseService(ExpenseRepository expenseRepository, UserRepository userRepository) {
        this.expenseRepository = expenseRepository;
        this.userRepository = userRepository;
    }

    public ExpenseDTO createExpense(ExpenseDTO expenseDTO){
        User user = userRepository.findById(expenseDTO.getUserId())
                .orElseThrow(()-> new RuntimeException("User does not exist!"));
        Expense expense = convertToEntity(expenseDTO , user);
        Expense savedExpense = expenseRepository.save(expense);

        return convertToDto(savedExpense);

    }

    public void removeExpense(Long id){
        expenseRepository.deleteById(id);
    }

    public ExpenseDTO updateExpense(ExpenseDTO expenseDTO, Long id){
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(()->new RuntimeException("No expense found!"));
        expense.setAmount(expenseDTO.getAmount());
        expense.setCategory(expenseDTO.getCategory());
        Expense updatedExpense = expenseRepository.save(expense);
        return convertToDto(updatedExpense);
    }

    public List<ExpenseDTO> findAllExpensesByUserId(Long userId){
        List<Expense> expenses = expenseRepository.findByUserId(userId);
        return expenses.stream()
                .map(this::convertToDto)
                .toList();
    }

//    public Optional<Expense> findById(Long id){
//        return expenseRepository.findById(id);
//    }

    public List<ExpenseDTO> findByUserIdAndCategory(Long userId, String category){
        return expenseRepository.findByUserIdAndCategory(userId, category)
                .stream()
                .map(this::convertToDto)
                .toList();
    }

    public List<ExpenseDTO> sortedExpense(Long userId, String order){
        List<Expense> expenses = expenseRepository.findByUserId(userId);
        expenses.sort((e1,e2)->"asc".equalsIgnoreCase(order)?

                Double.compare(e1.getAmount(),e2.getAmount()) :
                Double.compare(e2.getAmount(),e1.getAmount())

        );

        return expenses.stream()
                .map(this::convertToDto)
                .toList();
    }

    public Page<ExpenseDTO> pagedExpense(Long userId, Pageable pageable){
        return expenseRepository.findByUserId(userId, pageable).map(this::convertToDto);
    }

    public ExpenseDTO convertToDto(Expense expense){
        return new ExpenseDTO(
                expense.getCategory() ,
                expense.getAmount() ,
                expense.getUser().getId()
                );
    }
    public Expense convertToEntity(ExpenseDTO expenseDTO, User user){
        return new Expense(
                null,
                expenseDTO.getCategory() ,
                expenseDTO.getAmount(),
                user
        );
    }

}
