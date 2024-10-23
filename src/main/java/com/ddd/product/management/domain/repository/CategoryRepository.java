package com.ddd.product.management.domain.repository;
import java.util.Optional;

import com.ddd.product.management.domain.model.Category;

import java.util.List;

public interface CategoryRepository {
    Optional<Category> findById(Long id);
    List<Category> findAll();
    Category save(Category category);
    void deleteById(Long id);
    List<Category> findByName(String name);
}
