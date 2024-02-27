package com.Mateos.ProgrammingStudent.controller;

import com.Mateos.ProgrammingStudent.model.Curso;
import com.Mateos.ProgrammingStudent.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CursoController {
    @Autowired
    private ICursoService cursoServ;


    //crear nuevo curso
    @PostMapping("/cursos/crear")
    public String crearCurso(@RequestBody Curso curso){
        cursoServ.saveCurso(curso);
        return "Curso creado correctamente";
    }

    //obtener todos los cursos
    @GetMapping("/cursos/traer")
    public List<Curso> traerCursos(){
        return cursoServ.getCursos();
    }

    //obtener los cursos que tengan la palabra Java
    @GetMapping ("/cursos/java")
    public List<Curso> getCursosJava(){
        return cursoServ.getCursosJava();
    }

    //modificar los datos de un curso;
    @PutMapping("/curso/edit")
    public String editCurso(@RequestBody Curso curso){
        cursoServ.editCurso(curso);
        return "Curso editado correctamente";
    }


}
