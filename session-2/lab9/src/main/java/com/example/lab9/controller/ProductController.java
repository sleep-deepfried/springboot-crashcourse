package com.example.lab9.controller;

import com.example.lab9.model.Product;
import com.example.lab9.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController{
    private final ProductRepository productRepository; // Declare the dependency

    // Constructor Injection: Spring will automatically provide ProductRepository here
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products") // Maps HTTP GET requests to /products
    public List<Product> getAllProducts() {
        return productRepository.findAll(); // Call our repository to get all products
    }

    @GetMapping("/products/{id}") // {id} is a path variable
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        // Find the product by ID using the repository
        Optional<Product> product = productRepository.findById(id);

        // Check if the product was found
        if (product.isPresent()) {
            // If found, return it with HTTP 200 OK
            return ResponseEntity.ok(product.get()); // .get() gets the Product from Optional
        } else {
            // If not found, return HTTP 404 Not Found
            return ResponseEntity.notFound().build();
        }
    }
}
