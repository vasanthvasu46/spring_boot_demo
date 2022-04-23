package com.employee.repository;

import com.employee.entity.JuniorEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface JuniorEmployeeRepository extends JpaRepository<JuniorEmployee, Integer> {

    public List<JuniorEmployee> findBySeniorEmployeeId(int seniorId);

    @Query(value = "SELECT * from junior_employee WHERE location=?1", nativeQuery = true)
    public Collection<? extends JuniorEmployee> getJuniorEmployeeByLocation(String location);
}
