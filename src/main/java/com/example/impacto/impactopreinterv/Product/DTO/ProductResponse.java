package com.example.impacto.impactopreinterv.Product.DTO;


import lombok.Data;

@Data
public class ProductResponse {
    private String id;
    private String code;
    private String name;
    private String price;
    private String categoryId;
}
