package com.ddd.product.management.infrastructure.jpaRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ddd.product.management.domain.model.Category;

public interface JpaCategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByName(String name);
}
