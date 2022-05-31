package com.eco.repository;

import com.eco.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    void deleteEmployeeById(Long id);
    Optional<Employee> findEmployeeById(Long id);
    Optional<Employee> findEmployeeByUserNameAndPassword(String userName,String password);
}
