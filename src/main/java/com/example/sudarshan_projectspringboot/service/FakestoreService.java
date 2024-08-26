package com.example.sudarshan_projectspringboot.service;

import com.example.sudarshan_projectspringboot.dto.FakestoreDTO;
import com.example.sudarshan_projectspringboot.exception.ProductNotFoundException;
import com.example.sudarshan_projectspringboot.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakestoreService implements ProductService{
    @Override
    public Product getByProductId(long id) throws ProductNotFoundException {

        String url="https://fakestoreapi.com/products/" + id;
        RestTemplate restTemplate = new RestTemplate();
        FakestoreDTO fakestoreDTO = restTemplate.getForObject(url, FakestoreDTO.class);
        if(fakestoreDTO==null){
            throw new ProductNotFoundException("Product not found with id ");
        }

        return convertproduct(fakestoreDTO);
    }
    private Product convertproduct(FakestoreDTO dto){
        Product product = new Product();
        product.setProduct_description(dto.getDescription());
        product.setProduct_name(dto.getTitle());
        product.setCategory(dto.getCategory());
        return product;

    }
}
