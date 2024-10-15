package com.example.sudarshan_projectspringboot.service;

import com.example.sudarshan_projectspringboot.exception.ProductNotFoundException;
import com.example.sudarshan_projectspringboot.models.Product;
import org.springframework.data.domain.Page;

public interface ProductService {
    public Product getByProductById(long id) throws ProductNotFoundException;
    public Product createProduct(String name, String category,String Description);
    public Page<Product> getAllProduct(int pageSize, int pageNum);


}
