package com.example.ecommerce.CatalogueDemo.service;

import com.example.ecommerce.CatalogueDemo.entity.Product;
import com.example.ecommerce.CatalogueDemo.exception.RecordNotFoundException;
import com.example.ecommerce.CatalogueDemo.repository.ProductRepository;
import com.example.ecommerce.CatalogueDemo.service.converter.ProductConvertor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Product> retrieveAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> retrieveProductById(Long productId) {
        Optional<Product> productEntity = productRepository.findById(productId);
        productEntity.orElseThrow(() -> new RecordNotFoundException("Category not found with categoryId = "+ productId));
        return productRepository.findById(productId);
    }

    public String createProduct(Product product) {
        LOG.info("Creating person");
        Product productEntity = ProductConvertor.productModelToEntity(product);
        productRepository.save(productEntity);
        return productEntity.getName();
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
