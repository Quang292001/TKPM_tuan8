package com.example.service_a.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/serviceA")
public class ServiceAController {
    @Autowired
    private RestTemplate restTemplate;

    private static final String BASE_URL="http://localhost:8081/";

    private static final String SERVICE_A="Service A";
    @GetMapping
//    @CircuitBreaker(name = SERVICE_A,fallbackMethod = "serviceAFallback")
    @Retry(name = SERVICE_A)
    public String serviceA(){
        int count =1;
        String url=BASE_URL +"/serviceB";
        System.out.println("Retry method called "+ count++ +"time out");
        return restTemplate.getForObject(url,String.class);
    }
    public String serviceAFallback(Exception a){
        return "This is a fallback method for service A";
    }

}
