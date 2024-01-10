package com.example.example1.and2;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Plato {
    int idPlato;
    String nombre;
    double precio;
    String descripcion;

    public Plato() {
    }

    public Plato(int idPlato, String nombre, double precio, String descripcion) {
        this.idPlato = idPlato;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }
}
