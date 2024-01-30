package com.example.autowiredTest.controller;

import com.example.autowiredTest.model.Posteo;
import com.example.autowiredTest.repository.IPosteoRepository;
import com.example.autowiredTest.repository.PosteoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AplicationController {

    @Autowired
    IPosteoRepository repo;

    @GetMapping("/posteos")
    public List<Posteo> traerTodos(){

        return repo.traerTodos();
    }
}
