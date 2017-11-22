package com.crosstown.employee_control.services;

import com.crosstown.employee_control.domain.Employee;
import com.crosstown.employee_control.helper.SortByLastName;
import com.crosstown.employee_control.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author F.S.(Crosstown)
 * @date 11/21/17
 * @time 4:23 PM
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {


    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Set<Employee> getEmployees() {

        Set<Employee> employeeList = new HashSet<>();

        employeeRepository.findAll().iterator().forEachRemaining(employeeList::add);
        List sortedList = new ArrayList(employeeList);
        Collections.sort(sortedList, new SortByLastName());

        employeeList = new HashSet<>(sortedList);
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
