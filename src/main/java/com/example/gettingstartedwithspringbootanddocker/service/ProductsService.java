package com.example.gettingstartedwithspringbootanddocker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gettingstartedwithspringbootanddocker.model.Products;
import com.example.gettingstartedwithspringbootanddocker.repository.ProductsRepository;

@Service
public class ProductsService {
    
    @Autowired
    ProductsRepository productsRepository;

    public List<Products> getAllProducts() {
        
        return productsRepository.findAll();
    }

    public Optional<Products> findByProductId(Long productId) {
        return productsRepository.findById(productId);
    }
}
