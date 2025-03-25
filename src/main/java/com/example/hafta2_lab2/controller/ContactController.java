package com.example.hafta2_lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {

    @GetMapping("/contact")
    public String showContactPage(Model model) {
        model.addAttribute("title", "İletişim");
        model.addAttribute("content", "Bizimle iletişime geçmek için aşağıdaki bilgileri kullanabilirsiniz.");
        return "contact"; // contact.html dosyasına yönlendirme yapar
    }
}

