package com.example.module.webshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.module.webshop.entity.Customer;
import com.example.module.webshop.repository.CustomerRepository;

import java.util.Optional;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

public void saveCustomer(Customer customer) {
    customerRepository.save(customer);
    }


    public Customer checkIfCustomerExists(Customer customer){
        Optional<Customer> foundCustomer = customerRepository.findByUsernameAndPassword(customer.getUsername(), customer.getPassword());
        if (foundCustomer.isPresent()) {
            return foundCustomer.get();
        }
return null;

    }
}
