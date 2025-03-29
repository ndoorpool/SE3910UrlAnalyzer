package com.example.demo.controller;


import com.example.demo.domain.Customer;
import com.example.demo.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;

@AllArgsConstructor
@RestController
public class CustomerController {
    private final CustomerService customerService;

    @CrossOrigin
    @PostMapping("/user")
    public ResponseEntity<?> save(@RequestBody Customer customer) {

        System.out.println("Name : " + customer.getName());
        System.out.println("Password :  " + customer.getPassword());

        return new ResponseEntity<>(customerService.create(customer), HttpStatus.CREATED);


    }
}
