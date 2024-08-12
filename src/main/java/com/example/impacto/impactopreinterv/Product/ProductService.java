package com.example.impacto.impactopreinterv.Product;

import com.example.impacto.impactopreinterv.Category.Category;
import com.example.impacto.impactopreinterv.Category.CategoryRepository;
import com.example.impacto.impactopreinterv.Category.DTO.CategoryDTO;
import com.example.impacto.impactopreinterv.Category.DTO.CategoryListResponse;
import com.example.impacto.impactopreinterv.Product.DTO.ProductDTO;
import com.example.impacto.impactopreinterv.Product.DTO.ProductListResponse;
import com.example.impacto.impactopreinterv.utils.BaseResponse;
import com.example.impacto.impactopreinterv.utils.Response;
import com.example.impacto.impactopreinterv.utils.ResponseBuilder;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public BaseResponse<ProductListResponse> getAllProducts() {

        return ResponseBuilder.buildResponse(200, "Success", convertToListDto(productRepository.findAll()));
    }

    public BaseResponse<ProductDTO> getProductById(Long id) {
        return ResponseBuilder.buildResponse(200, "Success", convertToDto(productRepository.findById(id).orElse(null)));
    }

    public BaseResponse<String> createProduct(ProductDTO product) {
        if (product.getCode().isEmpty()){
            product.setCode(generateCode());
        } else if (productRepository.findByCode(product.getCode()).isPresent()) {
            product.setCode(product.getCode() + "1");
        }
        Category category = categoryRepository.findById(product.getCategoryId()).orElse(null);
        Product productEntity = convertToEntity(product);
        if (category != null){
            productEntity.setCategory(category);
        }
        productRepository.save(productEntity);
        return ResponseBuilder.buildResponse(200, "Success", "Product created successfully");
    }

    //generate code for product
    private String generateCode(){
        String code = "P";
        int count = productRepository.findAll().size();
        code += count;
        return code;
    }

    public BaseResponse<String> updateProduct(Long id, ProductDTO product) {

        if (productRepository.findById(id).isEmpty()) {
            return ResponseBuilder.buildResponse(404, "Error", "Product not found");
        }
        Product productEntity = convertToEntity(product);
        Category category;
        if (product.getCategoryId() != null) {
            category = categoryRepository.findById(product.getCategoryId()).orElse(null);
            if (category != null){
                productEntity.setCategory(category);
            }
        }

        productRepository.save(productEntity);
        return ResponseBuilder.buildResponse(200, "Success", "Product updated successfully");
    }


    public BaseResponse<String> deleteProduct(Long id) {
        if (productRepository.findById(id).isEmpty()) {
            return ResponseBuilder.buildResponse(404, "Error", "Product not found");
        }
        productRepository.deleteById(id);
        return ResponseBuilder.buildResponse(200, "Success", "Product deleted successfully");
    }

    private Product convertToEntity(ProductDTO productRequest) {
        return modelMapper.map(productRequest, Product.class);
    }

    private ProductDTO convertToDto(Product result) {
        return modelMapper.map(result, ProductDTO.class);
    }

    private ProductListResponse convertToListDto(List<Product> result) {
        List<ProductDTO> productDTOS = result.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

        ProductListResponse response = new ProductListResponse();
        response.setProducts(productDTOS);

        return response;
    }
}
