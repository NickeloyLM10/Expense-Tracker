package com.expense_tracker.dto;


public class BudgetDTO {

    private String category;
    private String month;
    private Double budgetLimit;
    private Long userId;


    public BudgetDTO(String category, String month, Double budgetLimit, Long userId) {
        this.category = category;
        this.month = month;
        this.budgetLimit = budgetLimit;
        this.userId = userId;
    }

    public String getCategory() {
        return category;
    }

    public String getMonth() {
        return month;
    }

    public Double getBudgetLimit() {
        return budgetLimit;
    }

    public Long getUserId() {
        return userId;
    }
}
