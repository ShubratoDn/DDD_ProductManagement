package com.ddd.product.management.infrastructure.persistence;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ddd.product.management.domain.model.Product;
import com.ddd.product.management.domain.repository.ProductRepository;
import com.ddd.product.management.infrastructure.jpaRepository.JpaProductRepository;


import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

	@Autowired
    private JpaProductRepository jpaProductRepository;

    @Override
    public Optional<Product> findById(Long id) {
        return jpaProductRepository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return jpaProductRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        return jpaProductRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        jpaProductRepository.deleteById(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return jpaProductRepository.findByName(name);
    }
}
