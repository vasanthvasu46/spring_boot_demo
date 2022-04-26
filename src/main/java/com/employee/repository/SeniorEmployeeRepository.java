package com.employee.repository;

import com.employee.entity.SeniorEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SeniorEmployeeRepository extends JpaRepository<SeniorEmployee, Integer> {

    @Query(value = "SELECT * from senior_employee WHERE location=?1", nativeQuery = true)
    public List<SeniorEmployee> getSeniorEmployeeByLocation(String location);
}

