package com.example.demo.repository;

import com.example.demo.domain.Customer;
import com.example.demo.domain.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {

    List<Url> findAllUrlsByCustomer(Customer customer);

}
