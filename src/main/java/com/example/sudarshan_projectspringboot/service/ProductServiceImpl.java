package com.example.sudarshan_projectspringboot.service;

import com.example.sudarshan_projectspringboot.exception.ProductNotFoundException;
import com.example.sudarshan_projectspringboot.models.Product;
import com.example.sudarshan_projectspringboot.projection.ProductInfo;
import com.example.sudarshan_projectspringboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("dbImpl")
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product getByProductId(long id) throws ProductNotFoundException {
        ProductInfo productInfo=productRepository.getProductInfo(id);
        Optional<Product> productOptional=productRepository.findById(id);
        if(productOptional.isPresent()){
            return productOptional.get();
        }else{
            throw new ProductNotFoundException("Product with id:" + id + " is not available");
        }

    }

    @Override
    public Product createProduct(String name, String category, String Description) {
        Product p = productRepository.findByNameAndCategory(name, category);
        if(p!=null){
            return p;
        }
        Product product=new Product();
        product.setName(name);
        product.setCategory(category);
        product.setDescription(Description);
        product=productRepository.save(product);

        return product;
    }
}
