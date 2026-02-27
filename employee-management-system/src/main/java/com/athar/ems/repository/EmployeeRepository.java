package com.athar.ems.repository;

import com.athar.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Long, Employee> {
}
