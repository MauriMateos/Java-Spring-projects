package com.example.demo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PropiedadDTO {

    //datos de propiedad
    private Long idPropiedad;
    private String tipoPropiedad;
    private String direccion;
    private Double valorAlquiler;
    //datos de inquilino
    private String nombre;
    private String apellido;

    public PropiedadDTO() {
    }

    public PropiedadDTO(Long idPropiedad, String tipoPropiedad, String direccion, Double valorAlquiler, String nombre, String apellido) {
        this.idPropiedad = idPropiedad;
        this.tipoPropiedad = tipoPropiedad;
        this.direccion = direccion;
        this.valorAlquiler = valorAlquiler;
        this.nombre = nombre;
        this.apellido = apellido;
    }
}
