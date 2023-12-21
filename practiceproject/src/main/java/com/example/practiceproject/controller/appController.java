package com.example.practiceproject.controller;

import com.example.practiceproject.Cliente;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class appController {
    @PostMapping("/cliente")
    public void crearCliente(@RequestBody Cliente cli){
        System.out.println("cliente creado");
        System.out.println("Nombre: "+cli.getNombre());
        System.out.println("Apellido: "+cli.getApellido());
    }
}
