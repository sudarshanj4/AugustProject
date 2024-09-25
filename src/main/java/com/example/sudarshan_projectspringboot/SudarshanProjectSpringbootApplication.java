package com.example.sudarshan_projectspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SudarshanProjectSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SudarshanProjectSpringbootApplication.class, args);
    }
        public Product updateById(long id, String name, String category, String description) throws ProductNotFoundException{
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new ProductNotFoundException("Product with id: " + id + " not found.");
        }

        Product p = optionalProduct.get();  // Get the actual Product from the Optional

        p.setCategory(category);
        p.setDescription(description);
        p.setName(name);
        p = productRepository.save(p);
        System.out.println(p.getId());
        return p;
    }

}
