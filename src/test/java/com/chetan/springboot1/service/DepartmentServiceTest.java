package com.chetan.springboot1.service;

import com.chetan.springboot1.entity.Department;
import com.chetan.springboot1.repository.DepartmentRepository;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean //mocking the repository layer
    private DepartmentRepository departmentRepository;

    // @BeforeEach vs @BeforeAll
    // Suppose 5 test methods are there. @BeforeEach will run before each test method.
    // @BeforeAll will run only once before all the test methods.

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .name("IT")
                .address("Mumbai")
                .code("IT-06")
                .id(1L)
                .build();

        Mockito.when(departmentRepository.findByNameIgnoreCase("IT")).thenReturn(department);
    }

    @Test //happy scenario
    @DisplayName("Get Data based on valid department name")
//    @Disabled
    public void whenValidDepartmentName_thenDepartmentShouldBeFound() {
        String name = "IT";
        Department department = departmentService.getDepartmentByName(name);
        assertEquals(name, department.getName());
    }
}