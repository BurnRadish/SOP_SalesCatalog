package com.example.productservie.RestController;

import com.example.productservie.POJO.Product;
import com.example.productservie.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;


    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public ResponseEntity<?> getProduct() {
        List<Product> product = productService.retrieveProduct();
        return ResponseEntity.ok(product);
    }

    @RequestMapping(value = "/product/{name}", method = RequestMethod.GET)
    public ResponseEntity<?> getSeleactedProduct(@PathVariable("name") String name) {
        List<Product> product = productService.retrieveProductByName(name);
        return ResponseEntity.ok(product);
    }
}
