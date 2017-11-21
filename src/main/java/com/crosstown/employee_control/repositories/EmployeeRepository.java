package com.crosstown.employee_control.repositories;

import com.crosstown.employee_control.domain.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * @author F.S.(Crosstown)
 * @date 11/21/17
 * @time 3:52 PM
 */
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
