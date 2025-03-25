package com.example.hafta2_lab2.service;

import com.example.hafta2_lab2.DTO.DepartmentDTO;
import com.example.hafta2_lab2.Mapper.DepartmentMapper;
import com.example.hafta2_lab2.model.Department;
import com.example.hafta2_lab2.respository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<DepartmentDTO> getAllDepartments(){
        List<Department> departments = departmentRepository.findAll();
        return departments.stream()
                .map(departmentMapper::departToDepartDTO)
                .collect(Collectors.toList());
    }
}
