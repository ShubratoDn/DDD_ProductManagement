package com.ddd.product.management.domain.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ddd.product.management.domain.model.Product;

public interface ProductRepository {
    Optional<Product> findById(Long id);
    Page<Product> findAll(Pageable pageable);
    Product save(Product product);
    void deleteById(Long id);
    List<Product> findByName(String name);
}
