package com.example.bank.controller;

import com.example.bank.model.Customer;
import com.example.bank.repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Girdhar Singh Rathore
 * @date Tuesday, September 26, 2023, 4:33 PM
 */
@RestController
public class LoginController {

    private CustomerRepository customerRepository;

    private PasswordEncoder passwordEncoder;

    public LoginController(CustomerRepository customerRepository,
                           PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer) {

        ResponseEntity response = null;
        try {
            String hashedPassword = passwordEncoder.encode(customer.getPwd());
            customer.setPwd(hashedPassword);
            Customer savedUser = customerRepository.save(customer);
            if (savedUser.getId() > 0) {
                response = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("User registered successfully.");
            }
        } catch (Exception e) {
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error occurred while registering user." + e.getMessage());
        }
        return response;
    }

}
