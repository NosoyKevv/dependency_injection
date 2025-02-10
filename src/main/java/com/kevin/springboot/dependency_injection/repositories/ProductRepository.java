package com.kevin.springboot.dependency_injection.repositories;

import com.kevin.springboot.dependency_injection.models.Product;

import java.util.Arrays;
import java.util.List;

public class ProductRepository {
    private List<Product> data;

    public ProductRepository() {
        this.data = Arrays.asList(
                new Product(1L, "memoria ram 32gb", 300L),
                new Product(2L, "ssd 512gb", 500L),
                new Product(3L, "teclado kamura 502", 280L),
                new Product(4L, "redragon 302 mouse", 120L)
        );
    }

    public List<Product> findAll() {
        return data;
    }

    public Product findById(Long id) {
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
    }
}
