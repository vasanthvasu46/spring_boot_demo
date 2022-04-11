package com.Employee.Repository;

import com.Employee.Model.JuniorEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JuniorEmployeeRepository extends JpaRepository<JuniorEmployee, Integer> {

    public List<JuniorEmployee> findBySeniorEmployeeId(int se_id);
}
