package com.crosstown.employee_control.services;

import com.crosstown.employee_control.domain.Employee;

import java.util.Set;

/**
 * @author F.S.(Crosstown)
 * @date 11/21/17
 * @time 4:13 PM
 */
public interface EmployeeService {

    Set<Employee> getEmployees();

    Employee findById(Long id);

    void deleteById(Long id);
}
