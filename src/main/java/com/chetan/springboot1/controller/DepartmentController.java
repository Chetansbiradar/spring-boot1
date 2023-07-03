package com.chetan.springboot1.controller;

import com.chetan.springboot1.entity.Department;
import com.chetan.springboot1.error.DepartmentNotFoundException;
import com.chetan.springboot1.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    //SL4J (Simple Logging Facade for Java) is a Java logging framework.
    // SLF4J is a simple facade for various logging frameworks, such as java.util.logging, logback and log4j.
    // SLF4J allows the end-user to plug in the desired logging framework at deployment time.
    // Basically, SLF4J is an abstraction layer between your application and the logging framework.
    // It provides a common interface to perform logging activities.
    // The underlying logging framework can be changed without changing the code in your application.
    // The SLF4J API supports various logging levels such as INFO, DEBUG, WARN, ERROR, and TRACE.
    // The logging level can be configured externally at deployment time.
    // The SLF4J API supports various logging frameworks such as Logback, Log4j, and java.util.logging.
    // You can choose any of the logging frameworks and configure it with SLF4J.
    //By default, SLF4J is configured with NOP (No Operation) logger.
    private final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> getAllDepartments(){
        LOGGER.info("Inside getAllDepartments of DepartmentController");
        return departmentService.getAllDepartments();
    }

    @GetMapping("/department/{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.getDepartmentById(departmentId);
    }

    @DeleteMapping("/department/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted successfully";
    }

    @PatchMapping("/department/{id}")
    public Department updateDepartmentById(@PathVariable("id") Long departmentId, @RequestBody Department department){
        Department updatedDepartment = departmentService.updateDepartmentById(departmentId, department);
        if(updatedDepartment==null){
            return null;
        }
        return updatedDepartment;
    }

    @GetMapping("/department/name/{name}")
    public Department getByName(@PathVariable("name") String departmentName){
        return departmentService.getDepartmentByName(departmentName);
    }
}
