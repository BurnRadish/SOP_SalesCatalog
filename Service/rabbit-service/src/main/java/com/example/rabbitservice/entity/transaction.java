package com.example.rabbitservice.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
@Data
public class transaction implements Serializable {
    private ArrayList<Object> tran;
    private String address;
    private double resultprice;
    private String email;
}
