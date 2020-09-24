package com.example.ecommerce.CatalogueDemo.service;

import com.example.ecommerce.CatalogueDemo.entity.Category;
import com.example.ecommerce.CatalogueDemo.entity.Product;
import com.example.ecommerce.CatalogueDemo.exception.RecordNotFoundException;
import com.example.ecommerce.CatalogueDemo.repository.CategoryRepository;
import com.example.ecommerce.CatalogueDemo.repository.ProductRepository;
import com.example.ecommerce.CatalogueDemo.service.converter.ProductConvertor;

import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private static final Logger LOG = LoggerFactory.getLogger(ProductService.class);
    private ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> retrieveAllProducts() {
        List<Product> products = productRepository.findAll();
        products.forEach(p -> System.out.println(p));
        products.forEach(p -> Hibernate.initialize(p.getCategories()));
        products.forEach(p -> System.out.println(p.getCategories()));
        return products;
    }

    public Optional<Product> retrieveProductById(Long productId) {
        Optional<Product> productEntity = productRepository.findById(productId);
        productEntity.orElseThrow(() -> new RecordNotFoundException("Category not found with categoryId = "+ productId));
        return productRepository.findById(productId);
    }

    public String createProduct(Product product) {
        LOG.info("Creating person");
        /*
        Product productEntity = ProductConvertor.productModelToEntity(product);
        productRepository.save(productEntity);
        return productEntity.getName();
        */
        Product newProd = new Product();
        newProd.setName(product.getName());
        newProd.setPrice(product.getPrice());
        newProd.setQuantity(product.getQuantity());
        newProd.setVersion(product.getVersion());
        
        newProd.getCategories().addAll(product.getCategories().stream()
        		.map(c -> { 
        				Category cat = categoryService.retrieveCategoryById(c.getId());
        				cat.getProducts().add(newProd);
        				return cat;
        			}).collect(Collectors.toList()));
        productRepository.save(newProd);
        return newProd.getName();
    }

    public Long updatePerson(Long productId, Product product) {
        LOG.info("Updating product with productId={}", productId);
        Optional<Product> productEntity = productRepository.findById(productId);
        productEntity.orElseThrow(() -> new RecordNotFoundException("Category not found with categoryId = "+ productId));
        Product mergedPersonEntity = ProductConvertor.productModelToEntity(product);
        productRepository.save(mergedPersonEntity);
        return productId;
    }

    public void deletePerson(Long productId) {
        LOG.info("deleting product with productId={}", productId);
        Optional<Product> productEntity = productRepository.findById(productId);
        productEntity.orElseThrow(() -> new RecordNotFoundException("Category not found with categoryId = "+ productId));
        productRepository.deleteById(productId);
    }
}