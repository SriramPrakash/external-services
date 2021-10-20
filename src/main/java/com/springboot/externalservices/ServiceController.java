package com.springboot.externalservices;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ServiceController {

    @RequestMapping("/")
    public String sayHello(){

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:3000", String.class);
        if(response.getStatusCode().is2xxSuccessful()){
            return response.getBody();
        }
        return "Hello";
    }
}
