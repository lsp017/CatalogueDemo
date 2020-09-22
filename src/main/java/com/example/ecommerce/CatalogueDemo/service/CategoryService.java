package com.example.ecommerce.CatalogueDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.CatalogueDemo.entity.Category;
import com.example.ecommerce.CatalogueDemo.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> retrieveAllCategories() {
		return categoryRepository.findAll();
	}
	
	public Optional<Category> retrieveCategoryById(Long id) {
		return categoryRepository.findById(id);
	}
}
