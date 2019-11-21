package io.catalyte.training.controllers;

import io.catalyte.training.security.AuthToken;
import io.catalyte.training.security.Credential;
import io.catalyte.training.services.CustomerAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/customer-login")
public class CustomerAuthController {

    private CustomerAuthService authService;

    @Autowired
    public CustomerAuthController(CustomerAuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    AuthToken login(@Valid @RequestBody Credential credentials) {
        return authService.login(credentials);
    }

}
