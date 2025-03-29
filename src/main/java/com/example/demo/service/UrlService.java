package com.example.demo.service;

import com.example.demo.domain.Book;
import com.example.demo.domain.Customer;
import com.example.demo.domain.Url;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.UrlRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.List;

@AllArgsConstructor
@Service
public class UrlService {

    private final UrlRepository urlRepository;
    private final CustomerRepository customerRepository;

    public Url create(Url url, String userId) {

        Customer customer = customerRepository.findByUserId(userId).orElse(null);

        System.out.println("UrlService > userId : " + userId);
        System.out.println("UrlService > create : " + customer.getCustomer_id());

        if(customer != null) {
            url.setCustomer(customer);
        }

        return urlRepository.save(url);

    }

    public List<Url> findAll(String userId){

        Customer customer = customerRepository.findByUserId(userId).orElse(null);

        System.out.println("UrlService > findAllByuserId  :  " +  userId);

        if(customer != null){
            return urlRepository.findAllUrlsByCustomer(customer);
        }

        return null;
    }

    @Transactional
    public List<Url> AllUrls() {
        return urlRepository.findAll();
    }

}
