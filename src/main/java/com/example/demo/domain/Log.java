package com.example.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String url;
    private String responseCode;
    private String sslProtocol;
    private String sslCipher;
    private String responseHeader;
    private Long sslExpiration;
    private String sslName;
}
