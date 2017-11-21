package com.crosstown.employee_control.services;

import com.crosstown.employee_control.domain.Employee;
import com.crosstown.employee_control.repositories.EmployeeRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @author F.S.(Crosstown)
 * @date 11/21/17
 * @time 4:23 PM
 */
public class EmployeeServiceImpl implements EmployeeService {


    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Set<Employee> getEmployees() {

        Set<Employee> employeeList = new HashSet<>();

        employeeRepository.findAll().iterator().forEachRemaining(employeeList::add);
        return employeeList;
    }

    @Override
    public Employee findById(Long l) {

        Optional<Employee> employeeOptional = employeeRepository.findById(l);

        if (!employeeOptional.isPresent()) {
            throw new RuntimeException("Employee not found!!");
        }

        return employeeOptional.get();
    }

    @Override
    public void deleteById(Long id) {

        employeeRepository.deleteById(id);

    }
}
