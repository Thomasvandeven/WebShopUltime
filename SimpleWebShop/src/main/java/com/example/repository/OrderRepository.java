package com.example.module.webshop.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.module.webshop.entity.CustomerOrder;

public interface OrderRepository extends CrudRepository<CustomerOrder, Long> {

  @Query("SELECT o FROM CustomerOrder AS o WHERE o.dispatched = true")
  List<CustomerOrder> findAllDispatchedOrders();

  @Query("SELECT o FROM CustomerOrder AS o WHERE o.dispatched = false")
  List<CustomerOrder> findAllNotDispatchedOrders();
}
