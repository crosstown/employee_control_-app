package com.crosstown.employee_control.repositories;

import com.crosstown.employee_control.domain.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author F.S.(Crosstown)
 * @date 11/21/17
 * @time 3:52 PM
 */
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Query(value = "SELECT * FROM employee ORDER BY first_name", nativeQuery = true)
    List<Employee> getAllSorted();
}

