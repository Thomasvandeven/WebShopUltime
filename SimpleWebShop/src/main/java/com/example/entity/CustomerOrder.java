package com.example.module.webshop.entity;

import java.util.List;
import javax.persistence.*;

@Entity
public class CustomerOrder {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long orderNumber;

  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
  private List<Product> products;

  @ManyToOne // Bi-directional relationship
  private Customer customer;

  private boolean dispatched;

  public CustomerOrder() {
    // Required by JPA
  }

  public CustomerOrder(List<Product> products, Customer customer) {
    this.products = products;
    this.customer = customer;
  }

  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Long getOrderNumber() {
    return orderNumber;
  }

  public boolean isDispatched() {
    return dispatched;
  }

  public void setDispatched(boolean dispatched) {
    this.dispatched = dispatched;
  }



}
