package com.example.ecommerce.CatalogueDemo.resource;

import com.example.ecommerce.CatalogueDemo.entity.Product;
import com.example.ecommerce.CatalogueDemo.repository.ProductRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/p1/products")
@Api("Set of Endpoints")
public class ProductController {
private final ProductRepository productRepository;
    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @ApiOperation("Get a product by ID")
    @GetMapping(value = "/{productId}")
    public ResponseEntity<Optional<Product>> retriveProductById (@PathVariable Long productId){
        System.out.println(productRepository.findAll());

        return ResponseEntity.status(HttpStatus.OK).body(productRepository.findById(productId));
    }

    @ApiOperation("Get all products")
    @GetMapping(value = "/getAll")
    public ResponseEntity<List<Product>> retriveAllProducts (){
        System.out.println(productRepository.findAll());

        return ResponseEntity.status(HttpStatus.OK).body(productRepository.findAll());
    }
}
