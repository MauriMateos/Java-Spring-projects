package com.Mateos.ProgrammingStudent.service;

import com.Mateos.ProgrammingStudent.dto.CursoTemaDTO;
import com.Mateos.ProgrammingStudent.model.Curso;

import java.util.List;

public interface ICursoService {
    List<Curso> getCursos(); //traemos toodos los cursos
    void saveCurso(Curso curso);
    void deleteCurso(Long id);
    Curso findCurso(Long id);
    void editCurso(Curso curso);
    CursoTemaDTO temasPorCurso(Long idCurso);
    List<Curso> getCursosJava();
}
