package com.athar.ems.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class EmployeeRequestDTO {

    @NotBlank(message = "First name can not be empty")
    @Size(min = 2, max = 50)
    private String firstName;

    @NotBlank(message = "Last can not be empty")
    @Size(min = 2, max = 50)
    private String lastName;

    @Email(message = "Email must be valid")
    @NotBlank(message = "Email can not be blank")
    private String email;

    public EmployeeRequestDTO() {}

    public EmployeeRequestDTO(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // getters and setters


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}