package com.crosstown.employee_control.helper;

import com.crosstown.employee_control.domain.Employee;

import java.util.Comparator;

/**
 * @author F.S.(Crosstown)
 * @date 11/22/2017
 * @time 1:42 AM
 */
public class SortByLastName implements Comparator<Employee> {

        // Used for sorting in ascending order of
        // roll name
        public int compare(Employee a, Employee b)
        {
            return a.getLastName().compareTo(b.getLastName());
        }
    }

