package com.Bazar.Bazar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoVenta;
    private LocalDate fechaVenta;

    @ManyToMany
    private List<Producto> listaProductos;
    // La relación entre una venta y sus productos es una relación uno a muchos
    // porque una venta puede tener múltiples productos asociados a ella
    // pero cada producto está asociado a una sola venta.
    // Por lo tanto, cada venta tiene una lista (o colección) de productos
    // pero no múltiples listas de productos.


    @OneToOne
    @JoinColumn(name = "id_cliente")
    Cliente unCliente;
}
