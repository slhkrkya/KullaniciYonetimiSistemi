package com.example.hafta2_lab2.Mapper;

import com.example.hafta2_lab2.DTO.AddressDTO;
import com.example.hafta2_lab2.DTO.UserDTO;
import com.example.hafta2_lab2.model.Address;
import com.example.hafta2_lab2.model.Department;
import com.example.hafta2_lab2.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDTO userToUserDTO(User user) {
        if (user == null) return null;
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());

        AddressDTO addressDTO = new AddressDTO();
        if (user.getAddress() != null) {
            addressDTO.setCity(user.getAddress().getCity());
            addressDTO.setStreet(user.getAddress().getStreet());
            addressDTO.setPostalCode(user.getAddress().getPostalCode());
            userDTO.setAddress(addressDTO);
        }

        Department department = user.getDepartment();
        if (department != null) {
            userDTO.setDepartmentId(user.getDepartment().getId());
            userDTO.setDepartmentName(department.getName());
        }

        return userDTO;
    }
    public User userDTOToUser(UserDTO userDTO, Department department) {
        if(userDTO == null) return null;
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());

        AddressDTO addressDTO = userDTO.getAddress();
        if (addressDTO != null) {
            Address address = new Address();
            address.setCity(addressDTO.getCity());
            address.setStreet(addressDTO.getStreet());
            address.setPostalCode(addressDTO.getPostalCode());
            user.setAddress(address);
        }

        user.setDepartment(department);
        return user;
    }
}
