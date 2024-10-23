package com.ddd.product.management.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ddd.product.management.application.ProductService;
import com.ddd.product.management.domain.model.Product;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Product createProduct(@Valid @RequestBody Product product) {
        return productService.createProduct(product);
    }


	@GetMapping
	public Page<Product> getAllProducts(
			@RequestParam(defaultValue = "0") int page, // Default to page 0 (first page)
			@RequestParam(defaultValue = "10") int size // Default page size of 10
	) {
		Pageable pageable = PageRequest.of(page, size);
		return productService.getAllProducts(pageable); // Return paginated products
	}

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@Valid @RequestBody Product product, @PathVariable Long id) {
        product.setId(id);
        return productService.updateProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
    
    @PatchMapping("/{id}/update-stock")
    public ResponseEntity<?>updateStock(@RequestBody Product product, @PathVariable Long id) {
    	if(product.getStockQuantity() == null || product.getStockQuantity() < 0) {
    		return ResponseEntity.badRequest().body("Stock quantity must be a non-negative integer");
    	}
        product.setId(id);
        Product productById = productService.getProductById(id);
        productById.setStockQuantity(product.getStockQuantity());
        return ResponseEntity.ok(productService.updateProduct(productById));
    }
    
}
