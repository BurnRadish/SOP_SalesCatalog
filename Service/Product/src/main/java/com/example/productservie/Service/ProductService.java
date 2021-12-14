package com.example.productservie.Service;

import com.example.productservie.POJO.Product;
import com.example.productservie.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> retrieveProduct() {
        return repository.findAll();
    }
    public List<Product> retrieveProductByName(String name) {
        return repository.findByByRegexpName(name);
    }
}
