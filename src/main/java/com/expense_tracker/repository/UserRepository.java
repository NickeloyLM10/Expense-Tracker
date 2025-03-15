package com.expense_tracker.repository;

import com.expense_tracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    public void deleteById(Long id);
    public Optional<User> findByEmail(String email);
}
