package com.example.personaldataservice.controller;

import com.example.personaldataservice.entities.AddNewPersonalRequest;
import com.example.personaldataservice.entities.PersonalRequest;
import com.example.personaldataservice.entities.PersonalResponse;
import com.example.personaldataservice.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping(value = "/address")
public class PersonalController {
    private PersonalService personalService;

    @Autowired
    public PersonalController(final PersonalService personalService){
        this.personalService = personalService;
    }

    @PostMapping(value = "")
    public ResponseEntity<PersonalResponse> address(@RequestBody PersonalRequest request){
        return ResponseEntity.ok(personalService.find(request));
    }

    @PostMapping(value = "/new")
    public ResponseEntity<Boolean> newAddress(@RequestBody AddNewPersonalRequest request){
        return ResponseEntity.ok(personalService.addNew(request));
    }
}
