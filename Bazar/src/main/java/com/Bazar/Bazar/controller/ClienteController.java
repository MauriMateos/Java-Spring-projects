package com.Bazar.Bazar.controller;

import com.Bazar.Bazar.model.Cliente;
import com.Bazar.Bazar.service.ClienteService;
import com.Bazar.Bazar.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private IClienteService clienteServ;

    @PostMapping("/clientes/crear")
    public String createCliente (@RequestBody Cliente cliente){
        clienteServ.saveCliente(cliente);
        return "cliente creado correctamente";
    }

    @GetMapping("/clientes")
    public List<Cliente> getClientes(){
        return  clienteServ.getClientes();
    }

    @GetMapping("/clientes/{id}")
    public Cliente getClienteById(@PathVariable Long id){
        return clienteServ.findClienteById(id);
    }

    @PutMapping("/clientes/edit")
    public String editCliente(@RequestBody Cliente cliente){
        clienteServ.editCliente(cliente);
        return "Cliente editado correctamente";
    }

    @DeleteMapping("/clientes/eliminar/{id}")
    public String deleteClienteById(@PathVariable Long id){
        clienteServ.deleteClienteById(id);
        return "Cliente eliminado correctamente";
    }
}
