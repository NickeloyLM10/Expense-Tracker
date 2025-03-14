package com.expense_tracker.controller;

import com.expense_tracker.dto.ExpenseDTO;
import com.expense_tracker.service.ExpenseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping("/create")
    public ExpenseDTO createExpense(@RequestBody ExpenseDTO expenseDTO){
        return expenseService.createExpense(expenseDTO);
    }

    @GetMapping("/{userId}")
    public List<ExpenseDTO> getAllExpenseByUserId(@PathVariable Long userId){
        return expenseService.findAllExpensesByUserId(userId);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteExpense(@PathVariable Long id){
        expenseService.removeExpense(id);
    }

    @PostMapping("/update/{id}")
    public ExpenseDTO updateExpense(@RequestBody ExpenseDTO expenseDTO, @PathVariable Long id){
        return expenseService.updateExpense(expenseDTO,id);
    }

    @GetMapping("/filter/{userId}/{category}")
    public List<ExpenseDTO> getExpenseByCategory(@PathVariable Long userId,@PathVariable String category){
        return expenseService.findByUserIdAndCategory(userId, category);
    }

    @GetMapping("/sorted/{userId}")
    public List<ExpenseDTO> sortedExpense(@PathVariable Long userId,@RequestParam String order){
        return expenseService.sortedExpense(userId, order);
    }

    @GetMapping("/paged/{userId}")
    public Page<ExpenseDTO> pagedExpense(@PathVariable Long userId, Pageable pageable){
        return expenseService.pagedExpense(userId, pageable);
    }
}
