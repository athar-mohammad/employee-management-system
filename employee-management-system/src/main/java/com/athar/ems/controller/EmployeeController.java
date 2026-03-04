package com.athar.ems.controller;

import com.athar.ems.dto.request.EmployeeRequestDTO;
import com.athar.ems.dto.response.ApiResponse;
import com.athar.ems.dto.response.DeleteUserApiResponse;
import com.athar.ems.dto.response.EmployeeResponseDTO;
import com.athar.ems.service.EmployeeService;
import jakarta.validation.Valid;
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
    public ResponseEntity<ApiResponse<EmployeeResponseDTO>> createEmployee(@Valid @RequestBody EmployeeRequestDTO requestDTO){
        EmployeeResponseDTO employee = employeeService.createEmployee(requestDTO);
        return ResponseEntity.ok(ApiResponse.success("Employee created successfully", employee));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<EmployeeResponseDTO>>> getAllEmployees(){

        List<EmployeeResponseDTO> allEmployee = employeeService.getAllEmployee();
        return ResponseEntity.ok(ApiResponse.success("Found Data", allEmployee));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<EmployeeResponseDTO>> getEmployee(@PathVariable Long id){

        EmployeeResponseDTO employeeById = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(ApiResponse.success("Employee Found", employeeById));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteUserApiResponse> deleteEmployee(@PathVariable  Long id){

        employeeService.deleteById(id);
        return ResponseEntity.ok(DeleteUserApiResponse.sucess("Deleted"));
    }

}
