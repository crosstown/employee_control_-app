package com.crosstown.employee_control.controllers;

import com.crosstown.employee_control.domain.Employee;
import com.crosstown.employee_control.services.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author F.S.(Crosstown)
 * @date 11/23/2017
 * @time 2:31 AM
 */
@Slf4j
@Controller
public class EmployeeController {

    EmployeeService employeeService;
    CategoryService categoryService;
    SupervisorService supervisorService;
    LocationService locationService;
    BUService buService;

    public EmployeeController(EmployeeService employeeService,
                              CategoryService categoryService,
                              SupervisorService supervisorService,
                              LocationService locationService,
                              BUService buService) {
        this.employeeService = employeeService;
        this.categoryService = categoryService;
        this.supervisorService = supervisorService;
        this.locationService = locationService;
        this.buService = buService;
    }

    @GetMapping
    @RequestMapping("employee/new")
    public String newEmployee(Model model){
        model.addAttribute("allCategory", categoryService.allCategory());
        model.addAttribute("allSupervisors", supervisorService.allSupervisors());
        model.addAttribute("allLocations", locationService.allLocations());
        model.addAttribute("allBU", buService.allBU());
        model.addAttribute("employee", new Employee());

        return "employee/new";
    }
    @PostMapping
    @RequestMapping("employee")
    public String saveOrUpdate(@ModelAttribute Employee command){
        Employee savedCommand = employeeService.saveEmployee(command);

        return "redirect:/";

     //   return "redirect:/employee/" + savedCommand.getId() + "/show";
    }

    @RequestMapping("/employee/{id}/show")
    public String showById(@PathVariable String id, Model model){

        model.addAttribute("employee", employeeService.findById(new Long(id)));

        return "employee/show";
    }

    @GetMapping
    @RequestMapping("employee/{id}/update")
    public String updateRecipe(@PathVariable String id, Model model){
        model.addAttribute("employee", employeeService.findById(Long.valueOf(id)));
        model.addAttribute("allCategory", categoryService.allCategory());
        model.addAttribute("allSupervisors", supervisorService.allSupervisors());
        model.addAttribute("allLocations", locationService.allLocations());
        model.addAttribute("allBU", buService.allBU());
        return  "employee/new";
    }

    @GetMapping
    @RequestMapping("employee/{id}/delete")
    public String deleteById(@PathVariable String id){

        log.debug("Deleting id: " + id);

        employeeService.deleteById(Long.valueOf(id));
        return "redirect:/";
    }
}
