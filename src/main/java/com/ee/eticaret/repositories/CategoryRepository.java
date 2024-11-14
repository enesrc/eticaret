package com.ee.eticaret.repositories;

import org.springframework.data.repository.CrudRepository;
import com.ee.eticaret.entities.Category;
import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
    List<Category> findAll();
}