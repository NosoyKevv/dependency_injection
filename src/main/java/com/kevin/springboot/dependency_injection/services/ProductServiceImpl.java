package com.kevin.springboot.dependency_injection.services;

import com.kevin.springboot.dependency_injection.models.Product;
import com.kevin.springboot.dependency_injection.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    //    @Autowired
    //  @Qualifier("productRepositoryImpl") //Por atributo se hace asi
    //@Autowired//Nos pasa una instancia que esta enel contenedro Principio hollywood nos nos llames nosotros te llamamos
    private ProductRepository repository; //no depende de una instancia (new) ahora toodo lo maneja el controlador
    //private ProductRepositoryImpl repository = new ProductRepositoryImpl();

    public ProductServiceImpl(@Qualifier("productRepositoryImpl") ProductRepository repository) {//Cuando tenemos un constructor podemos inyectar mediante el constructor y no es necesario el @Autowired
        this.repository = repository;//@Qualifier selecciona un componente por su nombre y lova a inyectar
    }

    /* @Autowired
    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }//Se puede inyerctar mediante los metodos setters
    */

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
