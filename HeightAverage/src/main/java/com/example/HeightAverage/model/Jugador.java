package com.example.HeightAverage.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Jugador {
    private Long id;
    private Long dni;
    private String nombre;
    private String apellido;
    private int edad;
    private double peso;
    private double estatura;
}
