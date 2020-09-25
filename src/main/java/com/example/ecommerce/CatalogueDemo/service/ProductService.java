package com.example.ecommerce.CatalogueDemo.service;

import com.example.ecommerce.CatalogueDemo.entity.Product;
import com.example.ecommerce.CatalogueDemo.exception.RecordNotFoundException;
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

@Service
public class ProductService {
    private static final Logger LOG = LoggerFactory.getLogger(ProductService.class);
    private ProductRepository productRepository;
    
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public List<Product> retrieveAllProducts() {
        List<Product> products = productRepository.findAll();
        products.forEach(p -> Hibernate.initialize(p.getCategories()));
        return products;
    }

    @Transactional
    public Optional<Product> retrieveProductById(Long productId) {
        Optional<Product> productEntity = productRepository.findById(productId);
        Hibernate.initialize(productEntity.get().getCategories());
        productEntity.orElseThrow(() -> new RecordNotFoundException("Product not found with productId = "+ productId));
        return productEntity;

    }

    public String createProduct(Product product) {
        LOG.info("Creating person");
       
        Product productEntity = ProductConvertor.productModelToEntity(product);
        
        productEntity.setName(product.getName());
        productEntity.setPrice(product.getPrice());
        productEntity.setQuantity(product.getQuantity());
        productEntity.setVersion(product.getVersion());
        productEntity.setCategories(product.getCategories());
        
        productRepository.save(productEntity);
        return productEntity.getName(); 
    }

    public Long updateProduct(Long productId, Product product) {
        LOG.info("Updating product with productId={}", productId);
        Optional<Product> productEntity = productRepository.findById(productId);
        
        productEntity.orElseThrow(() -> new RecordNotFoundException("Product not found with productId = "+ productId));
        Product mergedProductEntity = ProductConvertor.productModelToEntity(product);
        mergedProductEntity.setId(productId);
        productRepository.save(mergedProductEntity);
        return productId;
    }

    public void deleteProduct(Long productId) {
        LOG.info("Deleting product with productId={}", productId);
        Optional<Product> productEntity = productRepository.findById(productId);
        productEntity.orElseThrow(() -> new RecordNotFoundException("Product not found with productId = "+ productId));
        productRepository.deleteById(productId);
    }
}