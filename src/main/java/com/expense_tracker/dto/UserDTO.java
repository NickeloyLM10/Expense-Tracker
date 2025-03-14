package com.expense_tracker.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO {
    @JsonProperty("email")
    private String email;
    private Long id;

    public UserDTO(Long id , String email) {
        this.id = id;
        this.email = email;
    }


    public String getEmail() {
        return email;
    }

    public Long getId() {
        return id;
    }
}
