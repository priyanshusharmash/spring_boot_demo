package com.example.demo.student;

import jakarta.validation.constraints.NotNull;

public record StudentDto(
        @NotNull(message = "FirstName can't be null.")
        String firstName,
        @NotNull(message = "LastName can't be null.")
        String lastName,
        String email,
        Integer schoolId
) {
}
