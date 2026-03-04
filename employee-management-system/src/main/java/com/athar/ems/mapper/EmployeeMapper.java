package com.athar.ems.mapper;

import com.athar.ems.dto.request.EmployeeRequestDTO;
import com.athar.ems.dto.response.EmployeeResponseDTO;
import com.athar.ems.entity.Employee;

public class EmployeeMapper {

   // request -> Entity

    public static Employee mapToEmployee(EmployeeRequestDTO requestDTO){
        Employee employee = new Employee();

        employee.setFirstName(requestDTO.getFirstName());
        employee.setLastName(requestDTO.getLastName());
        employee.setEmail(requestDTO.getEmail());

        return employee;
    }

    //Entity -> Response
    public static EmployeeResponseDTO mapToEmployeeResponseDTO(Employee employee) {
        return new EmployeeResponseDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getCreatedAt()
        );
    }
}