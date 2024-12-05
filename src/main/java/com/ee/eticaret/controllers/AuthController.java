package com.ee.eticaret.controllers;

import com.ee.eticaret.entities.User;
import com.ee.eticaret.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.concurrent.CompletableFuture;

@Controller
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping("/signup")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "pages/signup";
    }

    @Async
    @PostMapping("/signup")
    public CompletableFuture<String> signUp(@ModelAttribute User user, RedirectAttributes redirectAttributes, Model model) {
        return CompletableFuture.supplyAsync(() -> {
            boolean isRegistered = authService.signup(user);

            if (isRegistered) {
                redirectAttributes.addFlashAttribute("signupSuccess", true);
                return "redirect:/signin";
            } else {
                model.addAttribute("loginError", true);
                return "pages/signup";
            }
        });
    }

    @GetMapping("/signin")
    public String showSignInForm(Model model) {
        model.addAttribute("user", new User());
        return "pages/signin";
    }

    @Async
    @PostMapping("/signin")
    public CompletableFuture<String> signIn(@ModelAttribute User user, Model model) {
        return CompletableFuture.supplyAsync(() -> {
            boolean isAuthenticated = authService.signin(user);

            if (isAuthenticated) {
                return "redirect:/products";
            } else {
                model.addAttribute("loginError", true);
                return "pages/signin";
            }
        });
    }
}