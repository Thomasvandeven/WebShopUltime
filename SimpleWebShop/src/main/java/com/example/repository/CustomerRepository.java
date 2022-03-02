package com.example.module.webshop.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.example.module.webshop.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
  Optional<Customer> findByUsername(String username);
  Optional<Customer> findByUsernameAndPassword(String username, String password);
}
