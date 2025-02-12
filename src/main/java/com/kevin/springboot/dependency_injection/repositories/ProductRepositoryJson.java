package com.kevin.springboot.dependency_injection.repositories;


import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kevin.springboot.dependency_injection.models.Product;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ProductRepositoryJson implements ProductRepository {

    private List<Product> list;

    public ProductRepositoryJson() {
        Resource resource = new ClassPathResource("product.json");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            list = Arrays.asList(objectMapper.readValue(resource.getFile(), Product[].class)); //readValue lo lee como un archivo y luego lo puebla en este objeto Product
        } catch (StreamReadException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Product> findAll() {
        return list;
    }

    @Override
    public Product findById(Long id) {
        return list.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }
}
