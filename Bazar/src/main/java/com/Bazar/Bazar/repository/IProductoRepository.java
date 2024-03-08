package com.Bazar.Bazar.repository;


import com.Bazar.Bazar.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepository extends JpaRepository<Producto,Long> {
}
