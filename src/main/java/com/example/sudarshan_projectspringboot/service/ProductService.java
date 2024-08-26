package com.example.sudarshan_projectspringboot.service;

import com.example.sudarshan_projectspringboot.exception.ProductNotFoundException;
import com.example.sudarshan_projectspringboot.models.Product;

public interface ProductService {
    public Product getByProductId(long id) throws ProductNotFoundException;
}
