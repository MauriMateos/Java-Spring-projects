package com.Mateos.ProgrammingStudent.repository;

import com.Mateos.ProgrammingStudent.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICursoRepository extends JpaRepository<Curso,Long> {
}
