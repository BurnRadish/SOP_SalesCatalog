package com.example.gatewayservice.config;

import org.springframework.stereotype.Component;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.function.Predicate;
@Component
public class RouterValidator {

    public static final List<String> openApiEndpoints = List.of(
            "/auth/register",
            "/auth/login"
    );

    public Predicate<ServerHttpRequest> isSecured =
            requset -> openApiEndpoints.stream().noneMatch(uri -> requset.getURI().getPath().contains(uri));
}
