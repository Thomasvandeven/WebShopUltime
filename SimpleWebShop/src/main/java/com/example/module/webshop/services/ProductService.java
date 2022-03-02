package com.example.module.webshop.services;


import com.example.module.webshop.entity.Customer;
import com.example.module.webshop.entity.Product;
import com.example.module.webshop.repository.CustomerRepository;
import com.example.module.webshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;


    @Autowired
    public ProductService (ProductRepository productRepository) {this.productRepository=productRepository;}

    public void saveProduct(Product product) {
        productRepository.save(product);
    }


    public Product checkIfProductExists(Product product){
        Optional<Product> foundProduct = productRepository.findByItemNumber(product.getItemNumber());
        if (foundProduct.isPresent()) {
            return foundProduct.get();
        }
        return null;
    }


}
