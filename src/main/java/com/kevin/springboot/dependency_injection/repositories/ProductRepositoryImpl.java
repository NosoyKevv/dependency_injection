package com.kevin.springboot.dependency_injection.repositories;

import com.kevin.springboot.dependency_injection.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Primary
@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private List<Product> data;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
                new Product(1L, "memoria ram 32gb", 300L),
                new Product(2L, "ssd 512gb", 500L),
                new Product(3L, "teclado kamura 502", 280L),
                new Product(4L, "redragon 302 mouse", 120L)
        );
    }

    @Override
    public List<Product> findAll() {
        return data;
    }

    @Override
    public Product findById(Long id) {
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
    }
}
