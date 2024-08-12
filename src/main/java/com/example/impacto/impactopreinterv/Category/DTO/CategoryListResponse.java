package com.example.impacto.impactopreinterv.Category.DTO;

import com.example.impacto.impactopreinterv.Category.Category;
import lombok.Data;

import java.util.List;

@Data
public class CategoryListResponse {
    private List<CategoryDTO> categories;
}
