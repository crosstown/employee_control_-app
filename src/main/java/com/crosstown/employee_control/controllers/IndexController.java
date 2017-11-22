package com.crosstown.employee_control.controllers;

import com.crosstown.employee_control.domain.Employee;
import com.crosstown.employee_control.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/** @author F.S.(Crosstown)
    @date 11/20/2017
    @time: 9:48 PM
*/
@Slf4j
@Controller
public class IndexController {

    private final EmployeeService employeeService;

    public IndexController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        System.out.println("hhhhhh");
        log.debug("Getting Index page");
        model.addAttribute("employees", employeeService.getEmployees());

        employeeService.getEmployees().forEach(System.out::println);
        return "index";
    }
}
