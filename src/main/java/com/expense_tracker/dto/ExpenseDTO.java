package com.expense_tracker.dto;


import java.time.LocalDate;

public class ExpenseDTO {
    private String category;
    private Double amount;
    private LocalDate localDate;
    private Long userId;

    public ExpenseDTO(String category, Double amount, Long userId, LocalDate localDate) {
        this.category = category;
        this.amount = amount;
        this.userId = userId;
        this.localDate = localDate;
    }

    public String getCategory() {
        return category;
    }

    public Double getAmount() {
        return amount;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public Long getUserId() {
        return userId;
    }
}
