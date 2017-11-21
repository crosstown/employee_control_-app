package com.crosstown.employee_control.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** @author F.S.(Crosstown)
    @date 11/20/2017
    @time: 9:48 PM
*/
@Slf4j
@Controller
public class IndexController {
    @RequestMapping({"", "/", "/index"})
    public String getIndexPage() {
        log.debug("Getting Index page");


        return "index";
    }
}
