package com.chetan.springboot1.service;

import com.chetan.springboot1.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> getAllDepartments();

    Department getDepartmentById(Long departmentId);

    void deleteDepartmentById(Long departmentId);

    Department updateDepartmentById(Long departmentId, Department department);

    Department getByName(String departmentName);
}
