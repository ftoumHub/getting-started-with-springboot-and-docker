package com.example.gettingstartedwithspringbootanddocker.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.gettingstartedwithspringbootanddocker.model.Products;
import com.example.gettingstartedwithspringbootanddocker.repository.ProductsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


@SpringBootTest
class ProductsServiceTest {
    @MockBean
    private ProductsRepository productsRepository;

    @Autowired
    private ProductsService productsService;

    /**
     * Method under test: {@link ProductsService#getAllProducts()}
     */
    @Test
    void testGetAllProducts() {
        ArrayList<Products> productsList = new ArrayList<>();
        when(productsRepository.findAll()).thenReturn(productsList);
        List<Products> actualAllProducts = productsService.getAllProducts();
        assertSame(productsList, actualAllProducts);
        assertTrue(actualAllProducts.isEmpty());
        verify(productsRepository).findAll();
    }

    /**
     * Method under test: {@link ProductsService#findByProductId(Long)}
     */
    @Test
    void testFindByProductId() {
        Products products = new Products();
        products.setCategory("Toothpaste");
        products.setId(1L);
        products.setName("Closeup Toothpaste");
        products.setPrice(78.0f);
        Optional<Products> ofResult = Optional.of(products);
        when(productsRepository.findById((Long) any())).thenReturn(ofResult);
        Optional<Products> actualFindByProductIdResult = productsService.findByProductId(1L);
        assertSame(ofResult, actualFindByProductIdResult);
        assertTrue(actualFindByProductIdResult.isPresent());
        verify(productsRepository).findById((Long) any());
    }
}

