package com.example.sudarshan_projectspringboot.controllers;


import com.example.sudarshan_projectspringboot.dto.CreateProductRequestDTO;
import com.example.sudarshan_projectspringboot.exception.ProductNotFoundException;
import com.example.sudarshan_projectspringboot.models.Product;
import com.example.sudarshan_projectspringboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
   @Autowired
   @Qualifier("dbImpl")
   private ProductService productService;

   @GetMapping("/{id}")
   public ResponseEntity<Product> getProductById(@PathVariable("id") long productid) throws ProductNotFoundException {
       Product product = productService.getByProductId(productid);
        return new ResponseEntity<>(product, HttpStatusCode.valueOf(200));
   }
@PostMapping()
    public Product createProduct(@RequestBody CreateProductRequestDTO createProductRequestDTO) {


       return productService.createProduct(createProductRequestDTO.getName(),createProductRequestDTO.getCategory(),createProductRequestDTO.getDescription());
}

}
