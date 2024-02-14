package com.Mateos.PruebaJPA.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    String nombre;
    String apellido;
    int edad;

     //Relacion 1 a 1 de mascota a persona | una persona tiene una mascota
    //@JoinColumn(name = "una_mascota_id_mascota", referencedColumnName = "idMascota")
    @OneToMany// cambiamos la relacion a 1 a n para tener una lista de mascotas posibles
    private List<Mascota> listaMascotas;
}
