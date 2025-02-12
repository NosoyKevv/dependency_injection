package com.kevin.springboot.dependency_injection;

import com.kevin.springboot.dependency_injection.repositories.ProductRepositoryJson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

    @Bean("productJson")
    public ProductRepositoryJson productRepositoryJson() {
        return new ProductRepositoryJson();
    }
}
