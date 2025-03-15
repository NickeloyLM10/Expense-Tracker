package com.expense_tracker.dto;


public record BudgetDTO(String category, String month, Double budgetLimit, Long userId) {

}
