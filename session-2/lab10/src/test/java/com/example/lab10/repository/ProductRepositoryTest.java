package com.example.lab10.repository;

import com.example.lab10.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    private ProductRepository repository;

    @BeforeEach
    void setUp() {
        repository = new ProductRepository();
    }

    @Test
    void testInitialProductsLoaded() {
        List<Product> products = repository.findAll();
        assertEquals(3, products.size(), "Should have 3 initial products");
    }

    @Test
    void testFindByIdExists() {
        Optional<Product> product = repository.findById(1L);
        assertTrue(product.isPresent());
        assertEquals("Laptop", product.get().getName());
    }

    @Test
    void testFindByIdNotFound() {
        Optional<Product> product = repository.findById(999L);
        assertFalse(product.isPresent());
    }

    @Test
    void testSaveNewProduct() {
        Product newProduct = new Product("Monitor", 150.00);
        Product saved = repository.save(newProduct);

        assertNotNull(saved.getId(), "Saved product should have an ID assigned");
        assertEquals("Monitor", saved.getName());
        assertEquals(4, repository.findAll().size(), "Should now have 4 products");
    }

    @Test
    void testUpdateExistingProduct() {
        Product existing = repository.findById(2L).orElseThrow();
        existing.setPrice(30.00);
        Product updated = repository.save(existing);

        assertEquals(30.00, updated.getPrice());
        assertEquals(3, repository.findAll().size(), "Should still have 3 products");
    }

    @Test
    void testUpdateWithNonExistingId() {
        Product product = new Product(999L, "GhostProduct", 999.99);
        Product result = repository.save(product);

        // This behavior just returns the same product without modifying the list
        assertEquals(product, result);
        assertEquals(3, repository.findAll().size(), "Should still have 3 products");
    }

    @Test
    void testProductListIsUnmodifiableFromOutside() {
        List<Product> products = repository.findAll();
        products.clear(); // should not affect internal list

        assertEquals(3, repository.findAll().size(), "Internal product list should remain unchanged");
    }
}
