package com.expense_tracker.repository;

import com.expense_tracker.model.Budget;
import com.expense_tracker.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BudgetRepository extends JpaRepository<Budget,Long> {
    List<Budget> findByUserIdAndMonth(Long userId, String month);
    List<Budget> findByUserIdAndCategory(Long userId, String category);
    List<Budget> findByUserId(Long userId);
    Page<Budget> findByUserId(Long userId, Pageable pageable);
}
