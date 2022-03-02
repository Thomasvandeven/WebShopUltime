package com.example.module.webshop.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.module.webshop.entity.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
  Category findByName(String name);
}
