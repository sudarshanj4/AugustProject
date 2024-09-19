package com.example.sudarshan_projectspringboot.repository;

import com.example.sudarshan_projectspringboot.models.Product;
import com.example.sudarshan_projectspringboot.projection.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByNameAndCategory(String name,String category);

    Optional<Product> findById(long id);


    @Query(nativeQuery = true,
    value = "Select p.id, p.name, p.description as descp from product p where id=:id")
    ProductInfo getProductInfo(@Param("id") long id);

}
