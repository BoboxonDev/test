package com.example.demo.product;


import com.example.demo.product.dto.ProductRequest;
import com.example.demo.product.dto.ProductResponse;

import java.util.List;

public interface ProductService {

    void create(ProductRequest request);

    List<ProductResponse> getAll();

    ProductResponse getById(Long id);

    void updateProduct(ProductRequest id);

    ProductResponse updateProduct(Long id, ProductRequest request);

    ProductResponse deleteProductById(Long id);

}
