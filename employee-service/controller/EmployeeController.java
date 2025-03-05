package employeeservice.controller;  // ✅ Match package name

import org.springframework.web.bind.annotation.*;
import employee_service.model.Employee;
import employee_service.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    // ✅ Test if API is running
    @GetMapping("/test")
    public String testApi() {
        return "Employee API is working!";
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return service.addEmployee(employee);
    }
}
