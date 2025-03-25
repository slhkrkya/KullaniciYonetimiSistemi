package com.example.hafta2_lab2.service;

import com.example.hafta2_lab2.DTO.AddressDTO;
import com.example.hafta2_lab2.DTO.UserDTO;
import com.example.hafta2_lab2.Mapper.UserMapper;
import com.example.hafta2_lab2.model.Address;
import com.example.hafta2_lab2.model.Department;
import com.example.hafta2_lab2.model.User;
import com.example.hafta2_lab2.respository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.hafta2_lab2.respository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private UserMapper userMapper;

    @Override
    public void saveUser(UserDTO userDTO) {
        Department department = departmentRepository.findById(userDTO.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Bölüm Bulunamadı"));
        User user = userMapper.userDTOToUser(userDTO, department);
        userRepository.save(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();

        return users.stream().map(user -> {
            UserDTO dto = new UserDTO();
            dto.setId(user.getId());
            dto.setName(user.getName());
            dto.setEmail(user.getEmail());

            // Adres dönüştürmesi
            AddressDTO addressDTO = new AddressDTO();
            addressDTO.setCity(user.getAddress().getCity());
            addressDTO.setStreet(user.getAddress().getStreet());
            addressDTO.setPostalCode(user.getAddress().getPostalCode());
            dto.setAddress(addressDTO);

            // Bölüm ID
            dto.setDepartmentId(user.getDepartment().getId());

            // Bölüm adı
            dto.setDepartmentName(user.getDepartment().getName());

            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(userMapper::userToUserDTO).orElse(null);
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        User existingUser = userRepository.findById(userDTO.getId())
                .orElseThrow(()-> new RuntimeException("Kullanıcı bulunamadı"));
        Department department = departmentRepository.findById(userDTO.getDepartmentId())
                .orElseThrow(()-> new RuntimeException("Bölüm bulunamadı"));
        existingUser.setName(userDTO.getName());
        existingUser.setEmail(userDTO.getEmail());

        Address address = new Address();
        address.setCity(userDTO.getAddress().getCity());
        address.setStreet(userDTO.getAddress().getStreet());
        address.setPostalCode(userDTO.getAddress().getPostalCode());
        existingUser.setAddress(address);

        existingUser.setDepartment(department);
        userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
