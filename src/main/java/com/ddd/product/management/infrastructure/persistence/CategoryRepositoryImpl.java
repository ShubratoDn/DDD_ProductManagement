package com.ddd.product.management.infrastructure.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ddd.product.management.domain.model.Category;
import com.ddd.product.management.domain.repository.CategoryRepository;
import com.ddd.product.management.infrastructure.jpaRepository.JpaCategoryRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
	
	@Autowired
	private JpaCategoryRepository jpaCategoryRepository;

	@Override
	public Optional<Category> findById(Long id) {
		return jpaCategoryRepository.findById(id);
	}

	@Override
	public List<Category> findAll() {
		return jpaCategoryRepository.findAll();
	}

	@Override
	public Category save(Category category) {
		return jpaCategoryRepository.save(category);
	}

	@Override
	public void deleteById(Long id) {
		jpaCategoryRepository.deleteById(id);
	}

	@Override
	public List<Category> findByName(String name) {
		return jpaCategoryRepository.findByName(name);
	}
}
