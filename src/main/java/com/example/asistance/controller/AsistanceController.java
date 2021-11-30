package com.example.asistance.controller;


import com.example.asistance.services.AsistantService;
import com.example.asistance.model.Asistant;
import com.example.asistance.model.User;
import com.example.asistance.utils.UserContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;


@RestController


public class AsistanceController {

    @Autowired
    private AsistantService asistantService;

    private static final Logger logger = LoggerFactory.getLogger(AsistanceController.class);

    @RolesAllowed({"ADMIN", "USER"})
    @RequestMapping(value = "/getall", method = RequestMethod.GET, produces = "application/json")
    public List<Asistant> getAsistants() throws TimeoutException {
        List<Asistant> myemp = new ArrayList<>();
        logger.debug("AsistanceServiceController Correlation id: {}", UserContextHolder.getContext().getCorrelationId());
        System.out.println(" Correlation id =>" + UserContextHolder.getContext().getCorrelationId());
        Asistant emp = new Asistant(1001, "ayse", "London", 1);
        Asistant emp2 = new Asistant(2002, "fatma", "Paris", 2);

        myemp.add(emp);
        myemp.add(emp2);

        return myemp;
    }


    @RolesAllowed({"ADMIN", "USER"})
    @GetMapping("/getFeignClientUser")
    public User getFeignClientUser() {
        List<Asistant> myemp = new ArrayList<>();
        Asistant emp = new Asistant(1001, "ayse", "London", 1);
        myemp.add(emp);
        User myUser = asistantService.getFeignData("1");

        return myUser;
    }


    @RolesAllowed({"ADMIN", "USER"})
    @GetMapping("/getRestClientUser")
    public User getRestClientUser() {
        List<Asistant> myemp = new ArrayList<>();
        Asistant emp = new Asistant(1001, "ayse", "London", 1);
        myemp.add(emp);
        User myUser = asistantService.getRestData("1");


        return myUser;
    }

    @GetMapping("/publicuser")
    public String getCode() throws Throwable {
        String accessToken = "";
        InputStreamReader isr = null;
        return accessToken;
    }

    @RolesAllowed({"ADMIN", "USER"})
    @GetMapping("/getAsistanceList")
    public List<Asistant> getdatam() throws Throwable {
        return asistantService.retrieveAsistantInfo();
    }


    @RolesAllowed({"ADMIN"})
    @GetMapping("/getRoleAdmin")
    public String getmyRole1() throws Throwable {
        return "Only admin cam view me";
    }

    @RolesAllowed({"USER"})
    @GetMapping("/getRoleUser")
    public String getmyRole2() throws Throwable {
        return "Only user can view me";
    }

    @RolesAllowed({"ADMIN", "USER"})
    @GetMapping("/getRoleBoth")
    public String getmyRole3() throws Throwable {
        return "Admin & User can view me";
    }


}
