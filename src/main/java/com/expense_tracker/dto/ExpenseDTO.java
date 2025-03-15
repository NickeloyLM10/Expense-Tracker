package com.expense_tracker.dto;


public record ExpenseDTO(String category, Double amount, Long userId) {
}
