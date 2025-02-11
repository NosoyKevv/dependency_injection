package com.kevin.springboot.dependency_injection.repositories;

import com.kevin.springboot.dependency_injection.models.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> findAll();
    Product findById(Long id);
}
