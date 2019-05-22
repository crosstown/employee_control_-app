package com.crosstown.employee_control.services;

import com.crosstown.employee_control.domain.*;
import com.crosstown.employee_control.repositories.EmployeeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;


import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;



/**
 * @author F.S.(Crosstown)
 * @date 5/18/18
 * @time 2:50 PM
 */
@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

    @Mock
    EmployeeRepository employeeRepository;

    @InjectMocks
    EmployeeServiceImpl employeeService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveEmployee () {
        Employee emp = new Employee();
        Category cat = new Category();
        Supervisor sup = new Supervisor();
        Location loc = new Location();
        BU bu = new BU();
        emp.setFirstName("Fernando");
        emp.setMiddleName("PEpe");
        emp.setLastName("Simon");
        emp.setEmail("myEmail@mycomp.com");
        emp.setSsn("5555555555");
        cat.setDescription("New Cate");
        emp.setCategory(cat);
        sup.setFirstName("Pene");
        sup.setLastName("Largo");
        emp.setSupervisor(sup);
        loc.setDescription("Monterrey");
        emp.setLocation(loc);
        bu.setDescription("DevOps");
        emp.setBu(bu);



        //when
        when(employeeRepository.save(any(Employee.class))).thenReturn(emp);


        //save employee
        Employee newEmp = employeeService.saveEmployee(emp);


        //verify the save
        assertEquals("Fernando", newEmp.getFirstName());

    }

}
