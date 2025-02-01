package com.example.demo.product;

import com.example.demo.product.dto.ProductRequest;
import com.example.demo.product.dto.ProductResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    ResponseEntity<Void> create(ProductRequest request) {
        productService.create(request);
        return null;
    }

    @GetMapping
    ResponseEntity<List<ProductResponse>> getAll() {return ResponseEntity.ok(productService.getAll());}

    @GetMapping("{id}")
    ResponseEntity<ProductResponse> getById(@PathVariable Long id) {return ResponseEntity.ok(productService.getById(id));}

    @PutMapping("{id}")
    ResponseEntity<Void> update(@RequestBody ProductRequest request, @PathVariable Long id) {
        productService.updateProduct(id,request);
        return null;
    }

    @DeleteMapping("{id}")
    ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.deleteProductById(id);
        return null;
    }
    
}
