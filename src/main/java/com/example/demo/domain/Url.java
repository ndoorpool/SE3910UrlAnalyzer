package com.example.demo.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long url_id;
    private String name;
    private String url;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
