package com.ee.eticaret.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.ee.eticaret.entities.Product;
import com.ee.eticaret.repositories.ProductRepository;

import java.util.Arrays;

@Component
public class ProductSeeder implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) {
        // Veritabanını temizle
        productRepository.deleteAll();

        // ID'nin 1'den başlamasını sağla
        jdbcTemplate.execute("ALTER TABLE product AUTO_INCREMENT = 1");

        // Örnek verileri oluştur
        Product p1 = new Product();
        p1.setName("Laptop Soğutucu");
        p1.setPrice("2000");
        p1.setStock(23);
        p1.setImage_path("/uploads/images/Abra_A5_v17_-_NH58_TR_-_rtx3050ti.png");

        Product p2 = new Product();
        p2.setName("Markasız Klavye");
        p2.setPrice("1000");
        p2.setStock(78);
        p2.setImage_path("/uploads/images/Abra_A5_v17_-_NH58_TR_-_rtx3050ti.png");

        Product p3 = new Product();
        p3.setName("Ekran Silme Suyu");
        p3.setPrice("400");
        p3.setStock(53);
        p3.setImage_path("/uploads/images/Abra_A5_v17_-_NH58_TR_-_rtx3050ti.png");

        Product p4 = new Product();
        p4.setName("Elma 10S");
        p4.setPrice("9000");
        p4.setStock(25);
        p4.setImage_path("/uploads/images/Abra_A5_v17_-_NH58_TR_-_rtx3050ti.png");

        Product p5 = new Product();
        p5.setName("Samsun s3 Mini");
        p5.setPrice("2000");
        p5.setStock(20);
        p5.setImage_path("/uploads/images/Abra_A5_v17_-_NH58_TR_-_rtx3050ti.png");

        Product p6 = new Product();
        p6.setName("Hacer Bilgisayar");
        p6.setPrice("20000");
        p6.setStock(30);
        p6.setImage_path("/uploads/images/Abra_A5_v17_-_NH58_TR_-_rtx3050ti.png");

        Product p7 = new Product();
        p7.setName("Monster Notebook Oyun Bilgisayarı");
        p7.setPrice("25000");
        p7.setStock(50);
        p7.setImage_path("/uploads/images/Abra_A5_v17_-_NH58_TR_-_rtx3050ti.png");

        Product p8 = new Product();
        p8.setName("Torku 50kg Şeker");
        p8.setPrice("3000");
        p8.setStock(40);
        p8.setImage_path("/uploads/images/Abra_A5_v17_-_NH58_TR_-_rtx3050ti.png");

        Product p9 = new Product();
        p9.setName("Bluetooth Kulaklık");
        p9.setPrice("500");
        p9.setStock(100);
        p9.setImage_path("/uploads/images/Abra_A5_v17_-_NH58_TR_-_rtx3050ti.png");

        Product p10 = new Product();
        p10.setName("Akıllı Saat");
        p10.setPrice("1500");
        p10.setStock(60);
        p10.setImage_path("/uploads/images/Abra_A5_v17_-_NH58_TR_-_rtx3050ti.png");

        // Veritabanına kaydet
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10));
    }
}