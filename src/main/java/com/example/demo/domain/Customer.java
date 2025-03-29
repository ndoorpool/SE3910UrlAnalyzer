package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customer_id;
    private String userId;
    private String Name;
    private String password;

    @OneToMany(mappedBy = "customer")
    private List<Url> urls = new ArrayList<>();
}
