package com.expense_tracker.service;

import com.expense_tracker.dto.BudgetDTO;
import com.expense_tracker.model.Budget;
import com.expense_tracker.model.User;
import com.expense_tracker.repository.BudgetRepository;
import com.expense_tracker.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetService {

    private final BudgetRepository budgetRepository;
    private final UserRepository userRepository;

    public BudgetService(BudgetRepository budgetRepository, UserRepository userRepository) {
        this.budgetRepository = budgetRepository;
        this.userRepository = userRepository;
    }

    public BudgetDTO createBudget(BudgetDTO budgetDTO){
        User user = userRepository.findById(budgetDTO.userId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        System.out.println("User Found: " + user.getEmail());
        Budget budget = convertToEntity(budgetDTO,user);
        Budget savedBudget = budgetRepository.save(budget);
        return convertToDTO(savedBudget);
    }

    public BudgetDTO updateBudget(BudgetDTO budgetDTO, Long id){
        Budget existingBudget = budgetRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Budget not found!"));
        existingBudget.setBudgetLimit(budgetDTO.budgetLimit());
        existingBudget.setCategory(budgetDTO.category());
        existingBudget.setMonth(budgetDTO.month());
        Budget updatedBudget = budgetRepository.save(existingBudget);
        return convertToDTO(updatedBudget);
    }

    public void removeBudget(Long id){
        budgetRepository.deleteById(id);
    }

    public List<BudgetDTO> getAllBudgetsByUserId(Long id){
        List<Budget> budgets = budgetRepository.findByUserId(id);
        return budgets.stream()
                .map(this::convertToDTO)
                .toList();
    }

//    public Optional<Budget> getBudgetById(Long id){
//        return budgetRepository.findById(id);
//    }

    public List<BudgetDTO> findBudgetByUserAndMonth(Long userId, String month){
        List<Budget> budgets = budgetRepository.findByUserIdAndMonth(userId,month);
        return budgets.stream()
                .map(this::convertToDTO)
                .toList();
    }

    public BudgetDTO findBudgetByUserAndCategory(Long userId, String category){
        Budget budget = budgetRepository.findByUserIdAndCategory(userId,category)
                .orElseThrow(()->new RuntimeException("Budget not found!"));
        return convertToDTO(budget);
    }

    public List<BudgetDTO> sortBudgets(Long userId, String order){
        List<Budget> budgetList = budgetRepository.findByUserId(userId);
        budgetList.sort((e1,e2)->"asc".equalsIgnoreCase(order)?

                Double.compare(e1.getBudgetLimit(),e2.getBudgetLimit()) :
                Double.compare(e2.getBudgetLimit(),e1.getBudgetLimit())

        );
        return budgetList.stream()
                .map(this::convertToDTO)
                .toList();
    }

    public Page<BudgetDTO> getPagedBudgets(Long userId, Pageable pageable){
        return budgetRepository.findByUserId(userId,pageable).map(this::convertToDTO);
    }
    public BudgetDTO convertToDTO(Budget budget){
        return new BudgetDTO(
                budget.getCategory(),
                budget.getMonth(),
                budget.getBudgetLimit(),
                budget.getUser().getId()
        );
    }
    public Budget convertToEntity(BudgetDTO budgetDTO, User user){
        return new Budget(
                budgetDTO.category(),
                budgetDTO.month(),
                budgetDTO.budgetLimit(),
                user
        );
    }
}
