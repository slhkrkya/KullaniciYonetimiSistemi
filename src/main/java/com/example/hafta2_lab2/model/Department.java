package com.example.hafta2_lab2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Bölüm adı zorunludur")
    private String name;

    public Department(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public Department() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Bölüm adı zorunludur") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Bölüm adı zorunludur") String name) {
        this.name = name;
    }
}
