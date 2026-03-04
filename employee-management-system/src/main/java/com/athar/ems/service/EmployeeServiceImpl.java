package com.athar.ems.service;

import com.athar.ems.exception.ResourceAlreadyExistsException;
import com.athar.ems.mapper.EmployeeMapper;
import com.athar.ems.dto.request.EmployeeRequestDTO;
import com.athar.ems.dto.response.EmployeeResponseDTO;
import com.athar.ems.entity.Employee;
import com.athar.ems.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }


    @Override
    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO requestDTO) {
        if(employeeRepository.existsByEmail(requestDTO.getEmail())){
            throw new ResourceAlreadyExistsException("Email already exists");
        }
        Employee employee = EmployeeMapper.mapToEmployee(requestDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeResponseDTO(savedEmployee);
    }

    @Override
    public List<EmployeeResponseDTO> getAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(EmployeeMapper::mapToEmployeeResponseDTO).toList();
    }
}
