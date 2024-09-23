package com.example.sudarshan_projectspringboot.controllers;


import com.example.sudarshan_projectspringboot.dto.CreateProductRequestDTO;
import com.example.sudarshan_projectspringboot.exception.ProductNotFoundException;
import com.example.sudarshan_projectspringboot.models.Product;
import com.example.sudarshan_projectspringboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
   @Autowired
   @Qualifier("fakeStore")
   private ProductService productService;

   @GetMapping("/{id}")
   public ResponseEntity<Product> getProductById(@PathVariable("id") long productId) throws ProductNotFoundException {
       Product product = productService.getByProductId(productId);
        return new ResponseEntity<>(product, HttpStatusCode.valueOf(200));
   }
@PostMapping()
    public Product createProduct(@RequestBody CreateProductRequestDTO createProductRequestDTO) {


       return productService.createProduct(createProductRequestDTO.getName(),createProductRequestDTO.getCategory(),createProductRequestDTO.getDescription());
}

@GetMapping()
    public ResponseEntity<Page<Product>> getAllProduct(
            @RequestParam(value = "pageSize",defaultValue = "20") int pageSize,
            @RequestParam(value = "pageNum",defaultValue = "0") int pageNo) {
    Page<Product> products=productService.getAllProduct(pageSize,pageNo);

       return ResponseEntity.ok(products);
}

}
