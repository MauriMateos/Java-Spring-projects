package com.Mateos.ProgrammingStudent.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCurso;
    private String nombre;
    private String modalidad;
    private String fechaFinalizacion;
    @OneToMany(mappedBy = "curso")
    private List<Tema> listaTemas;

}
