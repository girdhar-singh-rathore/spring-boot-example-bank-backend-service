package com.example.bank.user.controller;

import com.example.bank.model.UsersDetails;
import com.example.bank.repository.UsersDetailsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Girdhar Singh Rathore
 * @date Tuesday, September 26, 2023, 4:33 PM
 */
@RestController
public class LoginController {

    private UsersDetailsRepository usersDetailsRepository;

    public LoginController(UsersDetailsRepository usersDetailsRepository) {
        this.usersDetailsRepository = usersDetailsRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UsersDetails usersDetails) {

        ResponseEntity response = null;
        try {
            UsersDetails savedUser = usersDetailsRepository.save(usersDetails);
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