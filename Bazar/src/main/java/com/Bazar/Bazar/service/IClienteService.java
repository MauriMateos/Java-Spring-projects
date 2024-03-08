package com.Bazar.Bazar.service;

import com.Bazar.Bazar.model.Cliente;


import java.util.List;

public interface IClienteService {

    void saveCliente(Cliente cliente);

    List<Cliente> getClientes();

    void deleteClienteById(Long id);

    Cliente findClienteById(Long id);

    void editCliente(Cliente cliente);

}
