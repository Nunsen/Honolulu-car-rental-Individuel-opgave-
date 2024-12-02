package com.example.honolulu_fullstack_individuel_opgave.Service;

import com.example.honolulu_fullstack_individuel_opgave.Model.Customer;
import com.example.honolulu_fullstack_individuel_opgave.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    // Save a customer to the database
    public void saveCustomer(Customer customer) {
        customerRepo.saveCustomer(customer);
    }
}
