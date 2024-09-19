package com.example.sudarshan_projectspringboot.service;

import com.example.sudarshan_projectspringboot.dto.FakestoreDTO;
import com.example.sudarshan_projectspringboot.exception.ProductNotFoundException;
import com.example.sudarshan_projectspringboot.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("fakeStore")
public class FakestoreService implements ProductService{
    @Override
    public Product getByProductId(long id) throws ProductNotFoundException {

        String url="http://fakestoreapi.com/products/" + id;
        RestTemplate restTemplate = new RestTemplate();
        FakestoreDTO fakestoreDTO = restTemplate.getForObject(url, FakestoreDTO.class);
        if(fakestoreDTO==null){
            throw new ProductNotFoundException("Product not found with id "+id);
        }

        return convertproduct(fakestoreDTO);
    }

    @Override
    public Product createProduct(String name, String category, String Description) {
        return null;
    }

    @Override
    public Page<Product> getAllProduct(int pageSize, int pageNum) {
        return null;
    }

    private Product convertproduct(FakestoreDTO dto){
        Product product = new Product();
        product.setDescription(dto.getDescription());

        product.setCategory(dto.getCategory());
        return product;

    }
}
