package com.example.lab8.controller;

import com.example.lab8.model.Product;
import com.example.lab8.repository.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
