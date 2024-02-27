package com.Mateos.ProgrammingStudent.service;

import com.Mateos.ProgrammingStudent.dto.CursoTemaDTO;
import com.Mateos.ProgrammingStudent.model.Curso;
import com.Mateos.ProgrammingStudent.repository.ICursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CursoService implements ICursoService{

    @Autowired
    private ICursoRepository cursoRepo;
    @Override
    public List<Curso> getCursos() {
        return cursoRepo.findAll();
    }

    @Override
    public void saveCurso(Curso curso) {
        cursoRepo.save(curso);
    }

    @Override
    public void deleteCurso(Long id) {
        cursoRepo.deleteById(id);
    }

    @Override
    public Curso findCurso(Long id) {
        return cursoRepo.findById(id).orElse(null);
    }

    @Override
    public void editCurso(Curso curso) {
        this.saveCurso(curso);
    }

    @Override
    public CursoTemaDTO temasPorCurso(Long idCurso) {
        CursoTemaDTO curTemaDTO = new CursoTemaDTO();
        Curso curso = this.findCurso(idCurso);
        curTemaDTO.setNombreCurso(curso.getNombre());
        curTemaDTO.setListaTemas(curso.getListaTemas());
        return curTemaDTO;
    }

    @Override
    public List<Curso> getCursosJava() {
        String palabra = "Java";
        String textoComparar;
        List<Curso> listaCursos = this.getCursos();
        List<Curso> listaCursosJava = new ArrayList<>();
        for (Curso cur : listaCursos){
            textoComparar = cur.getNombre();
            boolean contieneJava = textoComparar.contains(palabra);
            if (contieneJava) listaCursosJava.add(cur);
        }
        return listaCursosJava;
    }
}
