package com.example.productservice.Service;

import com.example.productservice.POJO.Product;
import com.example.productservice.Repository.ProductRepository;
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

    public Product getProductId(String id){
        return repository.findBy_id(id);
    }

    //Update กับ create ทำงานเหมือนกัน แต่แยกไว้ให้เข้าใจง่ายขึ้น
    //หลักการทำงาน ส่งตัวใหม่เข้าไป -> เจอ id เดิม เขียนใหม่ทับไป แต่ถ้าไม่เจอสร้างใหม่
    public Product updateProduct(Product product){
        return repository.save(product);
    }

    public Product createProduct(Product book) {
        return repository.save(book);
    }

    public boolean deleteProduct(Product product) {
        try {
            repository.delete(product);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
