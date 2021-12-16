package com.example.personaldataservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddNewPersonalRequest {
    private String email;
    private String name;
    private String phone;
    private String address;
}
