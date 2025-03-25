package com.example.hafta2_lab2.config;

import com.example.hafta2_lab2.model.Department;
import com.example.hafta2_lab2.respository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public void run(String... args) throws Exception {
        if (departmentRepository.count() == 0) {
            departmentRepository.save(new Department(null, "Bilgisayar Mühendisliği"));
            departmentRepository.save(new Department(null, "Makine Mühendisliği"));
            departmentRepository.save(new Department(null, "Elektrik-Elektronik Mühendisliği"));
            departmentRepository.save(new Department(null, "Endüstri Mühendisliği"));
        }
    }
}
