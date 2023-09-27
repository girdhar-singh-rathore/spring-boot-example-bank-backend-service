package com.example.bank.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
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
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    private String email;
    private String pwd;
    private String role;

}
