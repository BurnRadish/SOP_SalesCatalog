package com.example.productservie.POJO;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Product")
public class Product {
    @Id
    private String _id;
    private String name;
    private String description;
    private int quantity;
    private int price;
    private String Urlimage;
    private String group;

    public Product(){}

    public Product(String _id, String name, String description, int quantity, int price, String urlimage, String group) {
        this._id = _id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        Urlimage = urlimage;
        this.group = group;
    }
}
