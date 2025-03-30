package com.example.demo.repository;

import com.example.demo.domain.Customer;
import com.example.demo.domain.Log;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogRepository extends JpaRepository<Log, Long> {

    List<Log> findAllLogsByCustomer(Customer customer);
}
