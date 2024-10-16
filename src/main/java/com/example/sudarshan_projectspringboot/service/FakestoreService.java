package com.example.sudarshan_projectspringboot.service;

import com.example.sudarshan_projectspringboot.UnsafeClient;
import com.example.sudarshan_projectspringboot.configuration.RedisConfig;
import com.example.sudarshan_projectspringboot.dto.FakestoreDTO;
import com.example.sudarshan_projectspringboot.exception.ProductNotFoundException;
import com.example.sudarshan_projectspringboot.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("fakeStore")
public class FakestoreService implements ProductService{

//    @Autowired
//    RestTemplate restTemplate;

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    @Override
    public Product getByProductById(long id) throws ProductNotFoundException {

        Product product = (Product) this.redisTemplate.opsForHash().get("PRODUCTS","product_"+id);
        if(product != null){
            return product;
        }
        String url="https://fakestoreapi.com/products/" + id;

        UnsafeClient.ignoreCertificates();
        RestTemplate restTemplate = new RestTemplate();

        FakestoreDTO fakestoreDTO = restTemplate.getForObject(url, FakestoreDTO.class);
        if(fakestoreDTO==null){
            throw new ProductNotFoundException("Product not found with id "+id);
        }
         product = convertproduct(fakestoreDTO);
        this.redisTemplate.opsForHash().put("PRODUCTS","product_"+id,product);
        return product;
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
        product.setName(dto.getTitle());
        product.setCategory(dto.getCategory());
        return product;

    }
}
