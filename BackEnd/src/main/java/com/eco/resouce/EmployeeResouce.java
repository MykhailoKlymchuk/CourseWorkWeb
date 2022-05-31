package com.eco.resouce;

import com.eco.model.Employee;
import com.eco.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResouce {
    private final EmployeeService employeeService;

    public EmployeeResouce(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.findAllEmployees();
        List<Employee> _employees = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.isConnectionStatus() && !employee.isUserRole())
                _employees.add(employee);
        }
        for (Employee employee : employees) {
            if (!employee.isConnectionStatus() && !employee.isUserRole())
                _employees.add(employee);
        }
        return new ResponseEntity<>(_employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee updateEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("login/{loginName}/{loginPassword}")
    public ResponseEntity<Employee> loginEmployee(
            @PathVariable("loginName") String loginName,
            @PathVariable("loginPassword") String loginPassword) {
        Employee employee = employeeService.findEmployeeByUserNameAndPassword(loginName, loginPassword);
        if (employee != null && !employee.isBlockStatus())
            return new ResponseEntity<>(employee, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
