package com.example.productservie.Repository;

import com.example.productservie.POJO.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    @Query(value="{ 'name' : { $regex: ?0 } }")
    public List<Product> findByByRegexpName(String name);

}
