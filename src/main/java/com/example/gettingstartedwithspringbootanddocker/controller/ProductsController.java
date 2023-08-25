package com.example.gettingstartedwithspringbootanddocker.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.gettingstartedwithspringbootanddocker.model.Products;
import com.example.gettingstartedwithspringbootanddocker.service.ProductsService;

@RestController
public class ProductsController {

    @Autowired
    ProductsService productsService;

    @GetMapping("/all/products")
    List<Products> getAllProducts() {
        return productsService.getAllProducts();
    }

    @GetMapping("/product/{productId}")
    ResponseEntity<Optional<Products>> getProductById(@PathVariable Long productId) {
        Optional<Products> product = productsService.findByProductId(productId);
        if (product.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }


}