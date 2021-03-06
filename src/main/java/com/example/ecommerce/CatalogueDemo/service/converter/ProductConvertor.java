package com.example.ecommerce.CatalogueDemo.service.converter;

import com.example.ecommerce.CatalogueDemo.entity.MonetaryAmount;
import com.example.ecommerce.CatalogueDemo.entity.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductConvertor {
    public static Product productModelToEntity(Product product) {
        Product productEntity = new Product(product.getName(),product.getPrice());
        MonetaryAmount monetaryAmount =new MonetaryAmount(product.getPrice().getCurrency(),product.getPrice().getValue());
        productEntity.setQuantity(product.getQuantity());
        productEntity.setId(product.getId());
        productEntity.setVersion(product.getVersion());
        product.setPrice(monetaryAmount);
        return productEntity;
    }
}
