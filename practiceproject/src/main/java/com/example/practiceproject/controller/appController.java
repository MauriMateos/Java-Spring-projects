package com.example.practiceproject.controller;

import com.example.practiceproject.Cliente;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class appController {
    @PostMapping("/cliente") //trabajamos con el metodo POST
    public void crearCliente(@RequestBody Cliente cli){
        System.out.println("cliente creado");
        System.out.println("Nombre: "+cli.getNombre());
        System.out.println("Apellido: "+cli.getApellido());
    }

    @GetMapping("/cliente/traer") //trabajamos con el metodo GET
    @ResponseBody
    public List<Cliente> traerClientes(){
        List<Cliente> listaClientes = new ArrayList<Cliente>();
        listaClientes.add(new Cliente(1L, "Zlatan", "Ibrahimovic"));
        listaClientes.add(new Cliente(2L, "Lionel", "Messi"));
        listaClientes.add(new Cliente(3L, "Cristiano", "Rolando"));

        return listaClientes;
    }

    @GetMapping("/pruebaresponse")
    ResponseEntity<String> traerRespuesta(){
        return new ResponseEntity<>("Esta es una prueba de response", HttpStatus.I_AM_A_TEAPOT);
    }
    //aqui manipulamos la respuesta HTTP
}
