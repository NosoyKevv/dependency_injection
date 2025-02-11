package com.kevin.springboot.dependency_injection.services;

import com.kevin.springboot.dependency_injection.models.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();
    Product findById(Long id);
}
