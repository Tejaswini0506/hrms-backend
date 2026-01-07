package com.hrms.controller;

import com.hrms.model.Employee;
import com.hrms.service.EmployeeService;
import com.hrms.service.AuthContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final AuthContext authContext;

    public EmployeeController(EmployeeService employeeService, AuthContext authContext) {
        this.employeeService = employeeService;
        this.authContext = authContext;
    }

    // ✅ ADMIN only
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        if (!authContext.isAdmin()) {
            return ResponseEntity.status(403).build();
        }
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return ResponseEntity.ok(savedEmployee);
    }

    // ✅ Everyone can read
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    // ✅ Everyone can read
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ ADMIN only
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable Long id,
            @RequestBody Employee employee) {

        if (!authContext.isAdmin()) {
            return ResponseEntity.status(403).build();
        }

        Employee updatedEmployee = employeeService.updateEmployee(id, employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    // ✅ ADMIN only
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        if (!authContext.isAdmin()) {
            return ResponseEntity.status(403).build();
        }
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
