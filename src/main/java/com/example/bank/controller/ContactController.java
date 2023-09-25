package com.example.bank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Girdhar Singh Rathore
 * @date Monday, September 25, 2023, 11:56 AM
 */
@RestController
public class ContactController {

    @GetMapping("/contact")
    public String getContactDetails() {
        return "Contact Details";
    }
}
