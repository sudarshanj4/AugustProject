package com.example.sudarshan_projectspringboot.controllers;


import com.example.sudarshan_projectspringboot.exception.ProductNotFoundException;
import com.example.sudarshan_projectspringboot.models.Product;
import com.example.sudarshan_projectspringboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
   @Autowired
   private ProductService productService;
   @GetMapping("/products/{id}")
   public ResponseEntity<Product> getProductById(@PathVariable("id") long productid) throws ProductNotFoundException {
       Product product = productService.getByProductId(productid);
        return new ResponseEntity<>(product, HttpStatusCode.valueOf(200));
   }
}
