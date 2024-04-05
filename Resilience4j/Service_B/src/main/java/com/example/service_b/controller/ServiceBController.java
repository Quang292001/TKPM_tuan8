package com.example.service_b.controller;

import org.springframework.boot.autoconfigure.quartz.QuartzTransactionManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/serviceB")
public class ServiceBController {

    @GetMapping
    public String serviceB(){
        return "Serivce B is called from service A";
    }
}
