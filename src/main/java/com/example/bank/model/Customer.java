package com.example.bank.model;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author Girdhar Singh Rathore
 * @date Monday, September 27, 2023, 08:22 PM
 */
@Entity
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "customer_id")
    private int id;
    private String name;
    private String email;
    @Column(name = "mobile_number")
    private String mobileNumber;

    private String pwd;
    private String role;
    @Column(name = "create_dt")
    private String createDt;

}
