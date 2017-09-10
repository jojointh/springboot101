package com.training.springboot.SpringbootPractices.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployeeController {

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    @ResponseBody
    public String listAllAnnotation() {

        System.out.println("### Enter to GET: /employees ###");

        return "hello";

    }
}
