package com.example.productservie.RestController;

import com.example.productservie.POJO.Product;
import com.example.productservie.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public ResponseEntity<?> getProduct() {
        List<Product> product = productService.retrieveProduct();
        return ResponseEntity.ok(product);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "/product/{name}", method = RequestMethod.GET)
    public ResponseEntity<?> getSeleactedProduct(@PathVariable("name") String name) {
        List<Product> product = productService.retrieveProductByName(name);
        return ResponseEntity.ok(product);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "/productDetail/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getProductDetail(@PathVariable("id") String id) {
        Product product = productService.getProductId(id);
        return ResponseEntity.ok(product);
    }

    //update product
    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "/product/update/{id}/{quantity}/{price}", method = RequestMethod.GET)
    public String updateProductQuantity(@PathVariable("id") String id, @PathVariable("quantity") int quantity, @PathVariable("price") int price) {
        Product product = productService.getProductId(id);
        if (product != null){
            product.setQuantity(quantity);
            product.setPrice(price);
            productService.updateProduct(product);
            return "Update product complete";
        }
        else {
            return "Product not found";
        }

    }

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "/create/{name}/{description}/{quantity}/{price}/{Urlimage}/{group}", method = RequestMethod.POST)
    public ResponseEntity<?> createProduct(@PathVariable("name") String name,
                                            @PathVariable("description") String description,
                                            @PathVariable("quantity") int quantity,
                                            @PathVariable("price") int price,
                                            @PathVariable("Urlimage") String Urlimage,
                                            @PathVariable("group") String group) {
        //null เพื่อ trigger id จะได้สร้างตัวใหม่
        Product newProduct = productService.createProduct(new Product(null, name, description, quantity, price, Urlimage, group));
        return ResponseEntity.ok(newProduct);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable("id") String id) {
        Product product = productService.getProductId(id);
        productService.deleteProduct(product);
        return "Delete product id : "+ id + " complete";
    }
}
