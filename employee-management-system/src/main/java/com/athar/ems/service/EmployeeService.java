package com.athar.ems.service;

import com.athar.ems.dto.request.EmployeeRequestDTO;
import com.athar.ems.dto.response.EmployeeResponseDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeResponseDTO createEmployee(EmployeeRequestDTO employeeDTO);
    List<EmployeeResponseDTO> getAllEmployee();
    EmployeeResponseDTO getEmployeeById(Long id);
    void deleteById(Long id);
}
