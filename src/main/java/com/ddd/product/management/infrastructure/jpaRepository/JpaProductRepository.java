package com.ddd.product.management.infrastructure.jpaRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ddd.product.management.domain.model.Product;

public interface JpaProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByName(String name);
}
