package com.example.esb.controller;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/esb/employees")
public class EmployeeController {
    @Autowired
    private ProducerTemplate producerTemplate;

    @GetMapping
    public Object getAllEmployees() {
        return producerTemplate.requestBody("direct:getEmployees", null);
    }

    @GetMapping("/{id}")
    public Object getEmployeeById(@PathVariable String id) {
        return producerTemplate.requestBodyAndHeader("direct:getEmployeeById", null, "id", id);
    }

    @PostMapping
    public Object createEmployee(@RequestBody String employee) {
        return producerTemplate.requestBody("direct:createEmployee", employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable String id) {
        producerTemplate.sendBodyAndHeader("direct:deleteEmployee", null, "id", id);
    }
}
