package com.example.hafta2_lab2.controller;

import com.example.hafta2_lab2.DTO.AddressDTO;
import com.example.hafta2_lab2.DTO.DepartmentDTO;
import com.example.hafta2_lab2.DTO.UserDTO;
import com.example.hafta2_lab2.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.example.hafta2_lab2.service.UserService;

import java.util.List;


@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public String listUsers(Model model) {
        List<UserDTO> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "list";
    }
    @GetMapping("/new")
    public String showNewUserForm(Model model) {
        UserDTO userDTO = new UserDTO();
        userDTO.setAddress(new AddressDTO());
        model.addAttribute("user", userDTO);
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "form";
    }

    @PostMapping("/save")
    public String saveOrUpdateUser(@Valid @ModelAttribute("user") UserDTO userDTO,
                                   BindingResult bindingResult,
                                   Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("departments", departmentService.getAllDepartments());
            return "form"; // hata varsa tekrar foma dön
        }
        if (userDTO.getId() == null) {
            userService.saveUser(userDTO);
        } else {
            userService.updateUser(userDTO);
        }
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String showEditUser(@PathVariable Long id, Model model) {
        UserDTO user = userService.getUserById(id);

        // Eğer adres null ise, boş adres DTO'su ekle
        if (user.getAddress() == null) {
            user.setAddress(new AddressDTO());
        }
        List<DepartmentDTO> departments = departmentService.getAllDepartments();
        model.addAttribute("user", user);
        model.addAttribute("departments", departments);
        return "form";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
