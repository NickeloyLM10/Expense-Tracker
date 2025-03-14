package com.expense_tracker.controller;

import com.expense_tracker.dto.BudgetDTO;
import com.expense_tracker.service.BudgetService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/budget")
public class BudgetController {

    private final BudgetService budgetService;

    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @PostMapping("/create")
    public BudgetDTO createBudget(@RequestBody BudgetDTO budgetDTO){
        return budgetService.createBudget(budgetDTO);
    }

    @GetMapping("/{userId}")
    public List<BudgetDTO> getAll(@PathVariable Long userId){
        return budgetService.getAllBudgetsByUserId(userId);
    }

    @DeleteMapping("/delete/{id}")
    public void removeService(@PathVariable Long id) {
        budgetService.removeBudget(id);
    }

    @PostMapping("/update/{id}")
    public BudgetDTO updateBudget(@RequestBody BudgetDTO budgetDTO, @PathVariable Long id){
        return budgetService.updateBudget(budgetDTO, id);
    }

    @GetMapping("/filter/category/{userId}/{category}")
    public List<BudgetDTO> getBudgetByCategory(@PathVariable Long userId,@PathVariable String category){
        return budgetService.findBudgetByUserAndCategory(userId, category);
    }

    @GetMapping("/filter/month/{userId}/{month}")
    public List<BudgetDTO> getBudgetByMonth(@PathVariable Long userId,@PathVariable String month){
        return budgetService.findBudgetByUserAndMonth(userId, month);
    }

    @GetMapping("/paged/{userId}")
    public Page<BudgetDTO> getPagedBudget(@PathVariable Long userId, Pageable pageable){
        return budgetService.getPagedBudgets(userId, pageable);
    }

    @GetMapping("/sort/{userId}")
    public List<BudgetDTO> getSortedBudget(@PathVariable Long userId,@RequestParam String order){
        return budgetService.sortBudgets(userId, order);
    }
}
