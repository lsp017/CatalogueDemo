package com.example.ecommerce.CatalogueDemo.service;

import java.util.List;
import java.util.Optional;

import com.example.ecommerce.CatalogueDemo.entity.Product;
import com.example.ecommerce.CatalogueDemo.service.converter.ProductConvertor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
