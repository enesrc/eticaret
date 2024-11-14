package com.ee.eticaret.services;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import com.ee.eticaret.entities.Product;

@Component
public class CartService {
    
    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void delProduct(Product product) {
        products.remove(product);
    }

    public void clearCart() {
        products.clear();
    }
}
