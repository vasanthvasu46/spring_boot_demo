package com.employee.repository;

import com.employee.entity.JuniorEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JuniorEmployeeRepository extends JpaRepository<JuniorEmployee, Integer> {

    public List<JuniorEmployee> findBySeniorEmployeeId(int seniorId);
}
