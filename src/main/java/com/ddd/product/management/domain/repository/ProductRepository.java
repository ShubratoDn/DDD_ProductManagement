package com.ddd.product.management.domain.repository;


import java.util.List;
import java.util.Optional;

import com.ddd.product.management.domain.model.Product;

public interface ProductRepository {
    Optional<Product> findById(Long id);
    List<Product> findAll();
    Product save(Product product);
    void deleteById(Long id);
    List<Product> findByName(String name);
}
