package com.example.ecommerce.CatalogueDemo.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.CatalogueDemo.entity.Category;
import com.example.ecommerce.CatalogueDemo.service.CategoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/categories")
@Api("Set of endpoints for Category")
public class CategoryController {

	@Autowired
	private CategoryService service;
	
	@ApiOperation("Endpoint to get all Categories")
	@GetMapping("/")
	public ResponseEntity<List<Category>> retrieveAllCategories() {
		return ResponseEntity.status(HttpStatus.OK).body(
				service.retrieveAllCategories());
	}
	
	@ApiOperation("Endpoint to get a Category details")
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Category>> retrieveCategoryById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.retrieveCategoryById(id));
		
	}
}
