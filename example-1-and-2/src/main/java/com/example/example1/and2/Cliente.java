package com.example.example1.and2;

import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.util.buf.UEncoder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter  @Setter
public class Cliente {
    int id;
    String dni;
    String nombre;
    String apellido;
    LocalDate fechaNacimiento;

    public Cliente() {
    }

    public Cliente(int id, String dni, String nombre, String apellido, LocalDate fechaNacimiento) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
    }
}
