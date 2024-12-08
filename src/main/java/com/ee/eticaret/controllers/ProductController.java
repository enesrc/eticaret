package com.ee.eticaret.controllers;

import com.ee.eticaret.entities.Product;
import com.ee.eticaret.entities.Category;
import com.ee.eticaret.services.ProductService;
import com.ee.eticaret.services.CategoryService;
import com.ee.eticaret.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CartService cartService;

    @GetMapping("/products")
    public String showProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("products", products);
        model.addAttribute("page", "products-list");
        model.addAttribute("title", "Ürünleri Keşfet");
        return "index";
    }

    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable Integer id, Model model) {
        Optional<Product> product = productService.getAProduct(id);
        if (product.isPresent()) {
            model.addAttribute("product", product.get());
            return "pages/product-details";
        } else {
            return "errors/product-not-found"; // daha yapılmadı.
        }
    }

    @GetMapping("/cart")
    public String showShoppingCart(Model model) {
        List<Product> products = cartService.getProducts();

        if (products.isEmpty()) {
            model.addAttribute("page", "shopping-cart-empty");
        } else {
            model.addAttribute("products", cartService.getProducts());
            model.addAttribute("page", "shopping-cart");
        }

        model.addAttribute("title", "birpazari.com - Sepet");
        return "index";
    }

    @GetMapping("/contact")
    public String showContact(Model model) {
        model.addAttribute("page", "contact");
        return "index";
    }

    @GetMapping("/about-us")
    public String showAboutUs(Model model) {
        model.addAttribute("page", "about-us");
        return "index";
    }

    @PostMapping("/add-to-cart")
    public String addToCart(@RequestBody Product product, Model model) {
        cartService.addProduct(product);

        List<Product> products = productService.getAllProducts();
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("products", products);
        model.addAttribute("page", "products-list");
        model.addAttribute("title", "Ürünleri Keşfet");
        return "index";
    }
    
}