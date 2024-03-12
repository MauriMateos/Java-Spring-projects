package com.Bazar.Bazar.repository;

import com.Bazar.Bazar.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository  extends JpaRepository<Cliente,Long> {
}
