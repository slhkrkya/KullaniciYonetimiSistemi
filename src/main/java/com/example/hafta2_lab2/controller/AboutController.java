package com.example.hafta2_lab2.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {

    @GetMapping("/about")
    public String showAboutPage(Model model) {
        model.addAttribute("title", "Hakkımızda");
        model.addAttribute("content", "Bu, kullanıcı yönetim sistemi hakkında bilgi veren sayfadır.");
        return "about"; // about.html dosyasına yönlendirme yapar
    }
}

