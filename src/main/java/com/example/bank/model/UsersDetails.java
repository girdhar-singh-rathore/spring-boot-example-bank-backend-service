package com.example.bank.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Girdhar Singh Rathore
 * @date Monday, September 25, 2023, 10:17 PM
 */

@Getter
@Setter
@Table(name = "users_details")
@Entity
public class UsersDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;
    private String pwd;
    private String role;

}
