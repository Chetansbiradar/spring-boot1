package com.chetan.springboot1.service;

import com.chetan.springboot1.entity.Department;
import com.chetan.springboot1.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> getAllDepartments();

    Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long departmentId);

    Department updateDepartmentById(Long departmentId, Department department);

    Department getDepartmentByName(String departmentName);
}
