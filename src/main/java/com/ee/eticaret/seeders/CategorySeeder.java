package com.ee.eticaret.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.ee.eticaret.entities.Category;
import com.ee.eticaret.repositories.CategoryRepository;

import java.util.Arrays;

@Component
public class CategorySeeder implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) {
        // Veritabanını temizle
        categoryRepository.deleteAll();

        // ID'nin 1'den başlamasını sağla
        jdbcTemplate.execute("ALTER TABLE category AUTO_INCREMENT = 1");

        // Örnek verileri oluştur
        Category p1 = new Category();
        p1.setName("Elektronik");

        Category p2 = new Category();
        p2.setName("Mobilya");

        Category p3 = new Category();
        p3.setName("Giyim");

        // Veritabanına kaydet
        categoryRepository.saveAll(Arrays.asList(p1, p2, p3));
    }
}