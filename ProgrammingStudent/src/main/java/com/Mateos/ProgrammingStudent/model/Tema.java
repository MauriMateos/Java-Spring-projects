package com.Mateos.ProgrammingStudent.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tema {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idTema;
    private String nombre;
    private String descripcion;
    @ManyToOne
    @JoinColumn(name="idCurso")
    @JsonIgnore //importante agregar para evitar errores de formato en la response
    Curso curso;
}
