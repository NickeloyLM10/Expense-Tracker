package com.expense_tracker.repository;

import com.expense_tracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    public void deleteById(Long id);
}
