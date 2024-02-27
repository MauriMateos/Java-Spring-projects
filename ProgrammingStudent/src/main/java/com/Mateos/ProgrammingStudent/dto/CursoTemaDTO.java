package com.Mateos.ProgrammingStudent.dto;

import com.Mateos.ProgrammingStudent.model.Tema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class CursoTemaDTO {

    private String nombreCurso;
    private List<Tema> listaTemas;

}
