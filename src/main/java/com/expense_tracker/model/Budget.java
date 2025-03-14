package com.expense_tracker.model;

import jakarta.persistence.*;

@Entity
@Table(name = "budget")
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String category;

    private String month;

    private Double budgetLimit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Budget(String category, String month, Double budgetLimit, User user) {
        this.category = category;
        this.month = month;
        this.budgetLimit = budgetLimit;
        this.user = user;
    }

    public Budget(){

    }

    public Double getBudgetLimit() {
        return budgetLimit;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setBudgetLimit(Double budgetLimit) {
        this.budgetLimit = budgetLimit;
    }

    public Long getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getMonth() {
        return month;
    }
}
