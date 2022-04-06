package com.example.project.controllers;

import com.example.project.entities.Owner;
import com.example.project.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.util.Random;

@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    private OwnerService ownerService;

    ZonedDateTime zonedDateTime = ZonedDateTime.now();
    int randomId = new Random().nextInt(100) + 10;

    @RequestMapping("hello")
    public String hello() {
        return "Hello";
    }

    @GetMapping(value = "")
    String index() {
        return "index";
    }

    @GetMapping("date")
    public ZonedDateTime getDateNow() {
        return zonedDateTime;
    }

    @PostMapping(value = "generateOwner", produces = MediaType.TEXT_PLAIN_VALUE)
    public String createExampleOwner() {

        Owner owner = new Owner(randomId, "Cyprian", "Zawadzki",
                "ul. Lidzka 76 Poznań", zonedDateTime.minusDays(200));
        ownerService.saveOwner(owner);

        return "Owner of id: " + randomId + " generated";
    }
}
