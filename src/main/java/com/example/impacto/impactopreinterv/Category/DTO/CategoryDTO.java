package com.example.impacto.impactopreinterv.Category.DTO;

import com.example.impacto.impactopreinterv.Product.DTO.ProductDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class CategoryDTO {
    private String id;
    @NotNull(message = "Name is required")
    @NotBlank(message = "Name is required")
    private String name;
    private List<ProductDTO> products;
}
