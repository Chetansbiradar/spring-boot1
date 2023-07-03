package com.chetan.springboot1.service;

import com.chetan.springboot1.entity.Department;
import com.chetan.springboot1.error.DepartmentNotFoundException;
import com.chetan.springboot1.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(departmentId);
        if(!department.isPresent()){
            throw new DepartmentNotFoundException("Department not Found");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartmentById(Long departmentId, Department department) {
        Department department1 = departmentRepository.findById(departmentId).get();
        if(department1==null){
            return null;
        }
        //check for null values or empty strings (getName setName getAddress setAddress getCode setCode)
        if(department.getName()!=null && !department.getName().isEmpty()){
            department1.setName(department.getName());
        }
        if(department.getAddress()!=null && !department.getAddress().isEmpty()){
            department1.setAddress(department.getAddress());
        }
        if(department.getCode()!=null && !department.getCode().isEmpty()){
            department1.setCode(department.getCode());
        }
        return departmentRepository.save(department1);
    }

    @Override
    public Department getByName(String departmentName) {
//        return departmentRepository.findByName(departmentName);
        return departmentRepository.findByNameIgnoreCase(departmentName);
    }


}
