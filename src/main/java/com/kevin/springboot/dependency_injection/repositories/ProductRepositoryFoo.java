package com.kevin.springboot.dependency_injection.repositories;


import com.kevin.springboot.dependency_injection.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

//@Primary
@Repository
public class ProductRepositoryFoo implements ProductRepository {
    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(1L, "Gabinete classultimated", 200L));
    }

    @Override
    public Product findById(Long id) {
        return new Product(id, "Gabinete classultimated", 200L);
    }
}
