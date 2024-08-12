package com.example.impacto.impactopreinterv.Category;


import com.example.impacto.impactopreinterv.Category.DTO.CategoryDTO;
import com.example.impacto.impactopreinterv.Category.DTO.CategoryListResponse;
import com.example.impacto.impactopreinterv.Category.DTO.CategoryRequest;
import com.example.impacto.impactopreinterv.utils.BaseResponse;
import com.example.impacto.impactopreinterv.utils.Response;
import com.example.impacto.impactopreinterv.utils.ResponseBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public BaseResponse<CategoryListResponse> getAllCategories() {
//        return convertToListDto(categoryRepository.findAll());
//        CategoryListResponse response = new CategoryListResponse();
//        response.setCategories(categoryRepository.findAll());
        return ResponseBuilder.buildResponse(200, "Success", convertToListDto(categoryRepository.findAll()));
    }

    public BaseResponse<String> createCategory(CategoryRequest category) {
        categoryRepository.save(convertToEntity(category));
        return ResponseBuilder.buildResponse(200, "Success", "Category created successfully");
    }

    private CategoryDTO convertToDto(Category result) {
        return modelMapper.map(result, CategoryDTO.class);
    }

//    private CategoryListResponse convertToListDto(List<Category> result) {
//        return modelMapper.map(result, CategoryListResponse.class);
//    }

    private CategoryListResponse convertToListDto(List<Category> result) {
        List<CategoryDTO> categoryDTOs = result.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

        CategoryListResponse response = new CategoryListResponse();
        response.setCategories(categoryDTOs);
        return response;
    }

    private Category convertToEntity(CategoryRequest categoryRequest) {
        return modelMapper.map(categoryRequest, Category.class);
    }


}
