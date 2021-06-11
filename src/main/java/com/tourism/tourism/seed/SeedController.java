package com.tourism.tourism.seed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/public/seed")
public class SeedController {
    @Autowired
    private SeedService seedService;

    @PutMapping(path = "all")
    public void runAll() {
        seedService.runAll();
    }

    @PutMapping(path = "tourist-anonymous")
    public void runTouristAnonymous() {
        seedService.runTouristAnonymous();
    }

    @PutMapping(path = "employee-admin")
    public void runEmployeeAdmin() {
    seedService.runEmployeeAdmin();
    }
    @GetMapping(path = "teste")
    public Boolean teste() {
        return true;
    }
}
