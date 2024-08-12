package com.example.impacto.impactopreinterv.Category.DTO;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CategoryRequest {
    @NotNull(message = "Name is required")
    @NotBlank(message = "Name is required")
    private String name;
}
