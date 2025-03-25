package com.example.hafta2_lab2.Mapper;

import com.example.hafta2_lab2.DTO.DepartmentDTO;
import com.example.hafta2_lab2.model.Department;
import org.springframework.stereotype.Component;

@Component
public class DepartmentMapper {
    public DepartmentDTO departToDepartDTO(Department department){
        if(department == null) return null;
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setId(department.getId());
        departmentDTO.setName(department.getName());
        return departmentDTO;
    }

    public Department departDTOToDepart(DepartmentDTO departmentDTO){
        if(departmentDTO == null) return null;
        Department department = new Department();
        department.setId(departmentDTO.getId());
        department.setName(departmentDTO.getName());
        return department;
    }
}
