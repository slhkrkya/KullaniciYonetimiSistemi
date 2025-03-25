package com.example.hafta2_lab2.DTO;

public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private AddressDTO address;
    private Long departmentId;
    private String departmentName;

    public UserDTO(Long id, String name, String email, AddressDTO address, Long departmentId, String departmentName) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    public UserDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
    public String getDepartmentName() {
        return departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
