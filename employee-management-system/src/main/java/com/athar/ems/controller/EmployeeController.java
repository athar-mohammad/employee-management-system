package com.athar.ems.controller;

import com.athar.ems.dto.request.EmployeeRequestDTO;
import com.athar.ems.dto.response.EmployeeResponseDTO;
import com.athar.ems.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<EmployeeResponseDTO> createEmployee(@RequestBody EmployeeRequestDTO requestDTO){
        EmployeeResponseDTO employee = employeeService.createEmployee(requestDTO);
        return ResponseEntity.ok(employee);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponseDTO>> getAllEmployees(){

        List<EmployeeResponseDTO> allEmployee = employeeService.getAllEmployee();
        return ResponseEntity.ok(allEmployee);
    }

}
