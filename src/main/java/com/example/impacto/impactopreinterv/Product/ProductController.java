package com.example.impacto.impactopreinterv.Product;

import com.example.impacto.impactopreinterv.Product.DTO.ProductDTO;
import com.example.impacto.impactopreinterv.Product.DTO.ProductListResponse;
import com.example.impacto.impactopreinterv.utils.BaseResponse;
import com.example.impacto.impactopreinterv.utils.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@Tag(name = "Product", description = "Endpoint for managing Product")
public class ProductController {
    private final ProductService productService;

    @Operation(
            summary = "Get All Products",
            description = "Get All Products.",
            tags = {"Product"})
    @ApiResponses(
            value = {
                @io.swagger.v3.oas.annotations.responses.ApiResponse(
                        description = "Success",
                        responseCode = "200",
                        content =
                                @io.swagger.v3.oas.annotations.media.Content(
                                        mediaType = "application/json",
                                        schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = ProductListResponse.class))),
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
    @GetMapping()
    public ResponseEntity<BaseResponse<ProductListResponse>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @Operation(
            summary = "Get Product By ID",
            description = "Get Product By ID.",
            tags = {"Product"})
    @ApiResponses(
            value = {
                @io.swagger.v3.oas.annotations.responses.ApiResponse(
                        description = "Success",
                        responseCode = "200",
                        content =
                                @io.swagger.v3.oas.annotations.media.Content(
                                        mediaType = "application/json",
                                        schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = ProductDTO.class))),
                @io.swagger.v3.oas.annotations.responses.ApiResponse(
                        description = "Not found",
                        responseCode = "404",
                        content = @io.swagger.v3.oas.annotations.media.Content),
                @io.swagger.v3.oas.annotations.responses.ApiResponse(
                        description = "Internal error",
                        responseCode = "500",
                        content = @io.swagger.v3.oas.annotations.media.Content)
            })
    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<ProductDTO>> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @Operation(
            summary = "Create Product",
            description = "Create Product.",
            tags = {"Product"})
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
            })
    @PostMapping()
    public ResponseEntity<BaseResponse<String>> createProduct(@Valid @RequestBody ProductDTO product) {
        System.out.println("Category ID : "+product.getCategoryId());
        return ResponseEntity.ok(productService.createProduct(product));
    }

    @Operation(
            summary = "Update Product",
            description = "Update Product.",
            tags = {"Product"})
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
            })
    @PutMapping("/{id}")
    public ResponseEntity<BaseResponse<String>> updateProduct(@PathVariable Long id, @Valid @RequestBody ProductDTO product) {
        return ResponseEntity.ok(productService.updateProduct(id, product));
    }

    @Operation(
            summary = "Delete Product",
            description = "Delete Product.",
            tags = {"Product"})
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
            })
    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse<String>> deleteProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productService.deleteProduct(id));
    }
}
