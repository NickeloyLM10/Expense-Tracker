package com.expense_tracker.dto;


import java.time.LocalDate;

public class ExpenseDTO {
    private String category;
    private Double amount;
    private Long userId;

    public ExpenseDTO(String category, Double amount, Long userId) {
        this.category = category;
        this.amount = amount;
        this.userId = userId;
    }

    public String getCategory() {
        return category;
    }

    public Double getAmount() {
        return amount;
    }

    public Long getUserId() {
        return userId;
    }
}
