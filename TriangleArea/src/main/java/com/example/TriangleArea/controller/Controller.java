package com.example.TriangleArea.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
@GetMapping("/triangleArea")
    public String area(@RequestParam double base,@RequestParam double altura){

    return "el area del triangulo es: " + (base * altura)/2;

}
}
