package com.example.personaldataservice.controller;

import com.example.personaldataservice.entities.AddNewPersonalRequest;
import com.example.personaldataservice.entities.PersonalResponse;
import com.example.personaldataservice.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/information")
public class PersonalController {
    private PersonalService personalService;

    @Autowired
    public PersonalController(final PersonalService personalService){
        this.personalService = personalService;
    }

    @GetMapping(value = "")
    public ResponseEntity<PersonalResponse> address(@RequestHeader String email){
        return ResponseEntity.ok(personalService.find(email));
    }

    @PostMapping(value = "/new")
    public ResponseEntity<Boolean> newAddress(@RequestBody AddNewPersonalRequest request){
        return ResponseEntity.ok(personalService.addNew(request));
    }
}
