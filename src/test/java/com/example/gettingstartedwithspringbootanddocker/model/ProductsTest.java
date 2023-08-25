package com.example.gettingstartedwithspringbootanddocker.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ProductsTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link Products}
     *   <li>{@link Products#setCategory(String)}
     *   <li>{@link Products#setId(Long)}
     *   <li>{@link Products#setName(String)}
     *   <li>{@link Products#setPrice(float)}
     *   <li>{@link Products#getCategory()}
     *   <li>{@link Products#getId()}
     *   <li>{@link Products#getName()}
     *   <li>{@link Products#getPrice()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Products actualProducts = new Products();
        actualProducts.setCategory("Category");
        actualProducts.setId(1L);
        actualProducts.setName("Name");
        actualProducts.setPrice(10.0f);
        assertEquals("Category", actualProducts.getCategory());
        assertEquals(1L, actualProducts.getId().longValue());
        assertEquals("Name", actualProducts.getName());
        assertEquals(10.0f, actualProducts.getPrice());
    }
}

