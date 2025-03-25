package com.example.hafta2_lab2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "isim boş olamaz")
    private String name;

    @Email(message = "Geçerli bir email adresi giriniz")
    @NotBlank(message = "Email zorunludur")
    private String email;

    @Embedded
    private Address address;

    @ManyToOne
    @JoinColumn(name = "deperment_id")
    private Department department;

    public User(Long id, String name, String email, Address address, Department department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.department = department;
    }

    public User(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "isim boş olamaz") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "isim boş olamaz") String name) {
        this.name = name;
    }

    public @Email(message = "Geçerli bir email adresi giriniz") @NotBlank(message = "Email zorunludur") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "Geçerli bir email adresi giriniz") @NotBlank(message = "Email zorunludur") String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
