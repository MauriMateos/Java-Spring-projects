package com.unitconverter.gallontoliter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConverterController {
    @GetMapping("/converter")
    public String convert(@RequestParam double gallon){

        double liters = gallon * 3.78541;
        return gallon + " gallons equals " + liters + " liters";
    }
}
