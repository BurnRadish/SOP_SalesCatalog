package com.example.loginregisterservice.controller;

import com.example.loginregisterservice.entities.AuthRequest;
import com.example.loginregisterservice.entities.AuthResponse;
import com.example.loginregisterservice.entities.RegisterResponse;
import com.example.loginregisterservice.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping(value = "/auth")
public class AuthController {
    private final AuthService authService;

    @Autowired
    public AuthController(final AuthService authService){
        this.authService = authService;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<AuthResponse> logIn(@RequestBody AuthRequest authRequest){
        return ResponseEntity.ok(authService.logIn(authRequest));
    }

    @PostMapping(value = "/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody AuthRequest authRequest){
        return ResponseEntity.ok(authService.register(authRequest));
    }
}
