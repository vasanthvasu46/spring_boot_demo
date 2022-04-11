package com.Employee.Repository;

import com.Employee.Model.SeniorEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeniorEmployeeRepository extends JpaRepository<SeniorEmployee, Integer> {
}
