package com.example.impacto.impactopreinterv.Product.DTO;

import com.example.impacto.impactopreinterv.Product.Product;
import lombok.Data;

import java.util.List;

@Data
public class ProductListResponse {
    private List<ProductDTO> products;
}
