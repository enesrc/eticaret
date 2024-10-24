package com.ee.eticaret.repositories;

import org.springframework.data.repository.CrudRepository;
import com.ee.eticaret.entities.Product;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findByName(String name);
    List<Product> findAll();
}