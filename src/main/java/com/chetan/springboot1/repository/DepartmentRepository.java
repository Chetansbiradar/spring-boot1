package com.chetan.springboot1.repository;

import com.chetan.springboot1.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    Department findByName(String departmentName); //Case sensitive
    Department findByNameIgnoreCase(String departmentName); //Case-insensitive

    //https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation

    //JPQL for custom query like name starts with
//    @Query("select d from Department d where d.name like ?1%") //does not work with mongodb
//    Department getDepartmentByNameStartsWith(String departmentName);

}
