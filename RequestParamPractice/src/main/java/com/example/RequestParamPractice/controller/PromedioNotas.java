package com.example.RequestParamPractice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PromedioNotas {

    @GetMapping("/promedio")
    public double prom(@RequestParam double prom1,@RequestParam double prom2,@RequestParam double prom3){
        return (prom1+prom2+prom3)/3;
    }

}
