package com.crosstown.employee_control.bootstrap;

import com.crosstown.employee_control.domain.*;
import com.crosstown.employee_control.repositories.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author F.S.(Crosstown)
 * @date 11/23/2017
 * @time 12:56 AM
 */

@Slf4j
@Component
public class EmployeeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryRepository categoryRepository;
    private final EmployeeRepository employeeRepository;
    private final SupervisorRepository supervisorRepository;
    private final LocationRepository locationRepository;
    private final BURepository buRepository;

    public EmployeeBootstrap(CategoryRepository categoryRepository, EmployeeRepository employeeRepository, SupervisorRepository supervisorRepository,
                             LocationRepository locationRepository, BURepository buRepository) {
        this.categoryRepository = categoryRepository;
        this.employeeRepository = employeeRepository;
        this.supervisorRepository = supervisorRepository;
        this.locationRepository = locationRepository;
        this.buRepository = buRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        employeeRepository.saveAll(getEmployees());

            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String passwd = passwordEncoder.encode("password"); //hashed pass
            String yo = passwordEncoder.encode("yo");
            System.out.println("my hashed password: " + passwd);   // show the hashed pass
            System.out.println("my hashed yo: " + yo);

        log.debug("Loading Bootstrap Data");
    }

    private List<Employee> getEmployees() {

        List<Employee> employees = new ArrayList<>(2);

        //get Supervisors
        Optional<Supervisor> barberiSupervisorOptional = supervisorRepository.findByLastName("Barberi");

        if(!barberiSupervisorOptional.isPresent()){
            throw new RuntimeException("Expected Supervisor Not Found");
        }

        Optional<Supervisor> zamoraSupervisorOptional = supervisorRepository.findByLastName("Zamora");

        if(!zamoraSupervisorOptional.isPresent()){
            throw new RuntimeException("Expected Supervisor Not Found");
        }

        // BU

        Optional<BU> buAOptional = buRepository.findByDescription("A");

        if(!buAOptional.isPresent()){
            throw new RuntimeException("Expected BU Not Found");
        }

        Optional<BU> buFinanceOptional = buRepository.findByDescription("Finance SS");

        if(!buFinanceOptional.isPresent()){
            throw new RuntimeException("Expected BU Not Found");
        }

        // Locations

        Optional<Location> locationPAOptional = locationRepository.findByDescription("Plant A");

        if(!locationPAOptional.isPresent()){
            throw new RuntimeException("Expected Location Not Found");
        }

        Optional<Location> locationUOptional = locationRepository.findByDescription("UTEC");

        if(!locationUOptional.isPresent()){
            throw new RuntimeException("Expected Location Not Found");
        }

        //get SupervisorOptionals
        Supervisor barberiSuper = barberiSupervisorOptional.get();
        Supervisor zamoraSuper = zamoraSupervisorOptional.get();
        BU buA = buAOptional.get();
        BU buFinance = buFinanceOptional.get();
        Location locPlantA = locationPAOptional.get();
        Location locUTEC = locationUOptional.get();

        //get Categories
        Optional<Category> developer3CategoryOptional = categoryRepository.findByDescription("Developer Class 3");

        if(!developer3CategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found");
        }

        Optional<Category> QACategoryOptional = categoryRepository.findByDescription("QA");

        if(!QACategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found");
        }

        Category dev3Category = developer3CategoryOptional.get();
        Category QACategory = QACategoryOptional.get();

        //Garcia employee
        Employee garciaEmployee = new Employee();
        garciaEmployee.setFirstName("Alberto");
        garciaEmployee.setLastName("Garcia");
        garciaEmployee.setEmail("agarcia@gmail.com");
        garciaEmployee.setSsn("09978654433");
        garciaEmployee.setSupervisor(barberiSuper);
        garciaEmployee.setCategory(dev3Category);
        garciaEmployee.setBu(buA);
        garciaEmployee.setLocation(locPlantA);



        //add to return list
        employees.add(garciaEmployee);


        //Perez employee
        Employee perezEmployee = new Employee();
        perezEmployee.setFirstName("Gustavo");
        perezEmployee.setLastName("Perez");
        perezEmployee.setEmail("perezga@gmail.com");
        perezEmployee.setSsn("09765654433");
        perezEmployee.setSupervisor(zamoraSuper);
        perezEmployee.setCategory(QACategory);
        perezEmployee.setLocation(locUTEC);
        perezEmployee.setBu(buFinance);


        employees.add(perezEmployee);

        return employees;
    }
}
