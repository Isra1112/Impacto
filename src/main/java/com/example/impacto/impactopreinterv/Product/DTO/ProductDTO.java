package com.example.impacto.impactopreinterv.Product.DTO;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductDTO {
    @NotBlank(message = "Code is required")
    @NotNull(message = "Code is required")
    private String code;
    @NotBlank(message = "Name is required")
    @NotNull(message = "Name is required")
    private String name;
    private Long price;
    private Long categoryId;
}
