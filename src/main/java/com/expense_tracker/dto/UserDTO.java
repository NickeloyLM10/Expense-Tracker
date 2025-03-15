package com.expense_tracker.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserDTO(
        Long id,
        @JsonProperty("email")
        String email,
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        String password)
{ }
