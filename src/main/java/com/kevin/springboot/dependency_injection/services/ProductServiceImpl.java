package com.kevin.springboot.dependency_injection.services;

import com.kevin.springboot.dependency_injection.models.Product;
import com.kevin.springboot.dependency_injection.repositories.ProductRepositoryImpl;
import com.kevin.springboot.dependency_injection.services.ProductService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductServiceImpl implements ProductService {

    private ProductRepositoryImpl repository = new ProductRepositoryImpl();

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream().map(p -> {
            Double priceImp = p.getPrice() * 1.25d;
            //Product newProduct = new Product(p.getId(), p.getName(), priceImp.longValue()); //principio de inmutabilidad
            Product newProd = (Product) p.clone(); //CLONE devuelve un tipo object entonces hacemos el cast para obtener el tipo de dato original (Product)// -> clonamos los datos del objeto original y luego le modificamos el precio y teroamos el newProduct
            newProd.setPrice(priceImp.longValue()); //creamos un Objet clone en product
            return newProd;
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }


}
