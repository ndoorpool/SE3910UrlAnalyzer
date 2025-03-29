package com.example.demo.service;


import com.example.demo.domain.Customer;
import com.example.demo.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public Customer create(Customer customer) {

        return customerRepository.save(customer);

    }
}
