package com.ddd.product.management.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddd.product.management.domain.model.Category;
import com.ddd.product.management.domain.model.Product;
import com.ddd.product.management.domain.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryService categoryRepository;

    public Product createProduct(Product product) {
        Category category = product.getCategory();
        if (category.getId() == null) {
            category = categoryRepository.createCategory(category);
            product.setCategory(category);
        } else {
            Category existingCategory = categoryRepository.getCategoryById(category.getId());
            product.setCategory(existingCategory);
        }
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found with id : "+id));
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Product updateProduct(Product product) {    	
        Category category = product.getCategory();
        if (category.getId() == null) {
            category = categoryRepository.createCategory(category);
            product.setCategory(category);
        } else {
            Category existingCategory = categoryRepository.getCategoryById(category.getId());
            product.setCategory(existingCategory);
        }
        return productRepository.save(product);
    }
}

