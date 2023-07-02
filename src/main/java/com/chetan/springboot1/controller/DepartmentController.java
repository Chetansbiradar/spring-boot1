package com.chetan.springboot1.controller;

import com.chetan.springboot1.entity.Department;
import com.chetan.springboot1.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department){
        System.out.println(department);
        return departmentService.saveDepartment(department);
    }
}
