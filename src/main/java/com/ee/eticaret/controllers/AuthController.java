package com.ee.eticaret.controllers;

import com.ee.eticaret.entities.User;
import com.ee.eticaret.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping("/signup")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String signUp(@ModelAttribute User user, RedirectAttributes redirectAttributes, Model model) {
        boolean isRegistered = authService.signup(user);

        if(isRegistered){
            redirectAttributes.addFlashAttribute("signupSuccess", true);
            return "redirect:/signin";
        } else {
            model.addAttribute("loginError", true);
            return "signup";
        }
    }

    @GetMapping("/signin")
    public String showSignInForm(Model model) {
        model.addAttribute("user", new User());
        return "signin";
    }

    @PostMapping("/signin")
    public String signIn(@ModelAttribute User user, Model model) {
        boolean isAuthenticated = authService.signin(user);
        
        if (isAuthenticated) {
            return "redirect:/products";
        } else {
            model.addAttribute("loginError", true);
            return "signin";
        }
    }
}