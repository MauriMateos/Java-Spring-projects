package com.Bazar.Bazar.repository;

import com.Bazar.Bazar.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository  extends JpaRepository<Cliente,Long> {
}
