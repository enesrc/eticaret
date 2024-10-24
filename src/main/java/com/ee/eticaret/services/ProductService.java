package com.ee.eticaret.services;

import com.ee.eticaret.entities.Product;
import com.ee.eticaret.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getAProduct(Integer id) {
        return productRepository.findById(id);
    }
}