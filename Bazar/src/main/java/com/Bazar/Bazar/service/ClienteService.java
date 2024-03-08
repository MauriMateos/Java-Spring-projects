package com.Bazar.Bazar.service;

import com.Bazar.Bazar.model.Cliente;
import com.Bazar.Bazar.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private IClienteRepository clienteRepo;

    @Override
    public void saveCliente(Cliente cliente) {
        clienteRepo.save(cliente);
    }

    @Override
    public List<Cliente> getClientes() {
        return clienteRepo.findAll();
    }

    @Override
    public void deleteClienteById(Long id) {
        clienteRepo.deleteById(id);
    }

    @Override
    public Cliente findClienteById(Long id) {
        return clienteRepo.findById(id).orElse(null);
    }

    @Override
    public void editCliente(Cliente cliente) {
        clienteRepo.save(cliente);
    }
}
