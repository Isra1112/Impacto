package com.example.impacto.impactopreinterv.Category;


import com.example.impacto.impactopreinterv.Category.DTO.CategoryListResponse;
import com.example.impacto.impactopreinterv.Category.DTO.CategoryRequest;
import com.example.impacto.impactopreinterv.utils.BaseResponse;
import com.example.impacto.impactopreinterv.utils.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
@Tag(name = "Category", description = "Endpoint for managing Category")
public class CategoryController {
    private final CategoryService categoryService;

    @Operation(
            summary = "Get All Categories",
            description = "Get All Categories.",
            tags = {"Category"})
    @ApiResponses(
            value = {
                @io.swagger.v3.oas.annotations.responses.ApiResponse(
                        description = "Success",
                        responseCode = "200",
                        content =
                                @io.swagger.v3.oas.annotations.media.Content(
                                        mediaType = "application/json",
                                        schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = CategoryListResponse.class))),
                @io.swagger.v3.oas.annotations.responses.ApiResponse(
                        description = "Not found",
                        responseCode = "404",
                        content = @io.swagger.v3.oas.annotations.media.Content),
                @io.swagger.v3.oas.annotations.responses.ApiResponse(
                        description = "Internal error",
                        responseCode = "500",
                        content = @io.swagger.v3.oas.annotations.media.Content)
            }
    )
    @GetMapping
    public ResponseEntity<BaseResponse<CategoryListResponse>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @Operation(
            summary = "Create Category",
            description = "Create Category.",
            tags = {"Category"})
    @ApiResponses(
            value = {
                @io.swagger.v3.oas.annotations.responses.ApiResponse(
                        description = "Success",
                        responseCode = "200",
                        content =
                                @io.swagger.v3.oas.annotations.media.Content(
                                        mediaType = "application/json",
                                        schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = String.class))),
                @io.swagger.v3.oas.annotations.responses.ApiResponse(
                        description = "Not found",
                        responseCode = "404",
                        content = @io.swagger.v3.oas.annotations.media.Content),
                @io.swagger.v3.oas.annotations.responses.ApiResponse(
                        description = "Internal error",
                        responseCode = "500",
                        content = @io.swagger.v3.oas.annotations.media.Content)
            }
    )
    @PostMapping
    public ResponseEntity<BaseResponse<String>> createCategory(@Valid @RequestBody CategoryRequest category) {
        return ResponseEntity.ok(categoryService.createCategory(category));
    }
}
