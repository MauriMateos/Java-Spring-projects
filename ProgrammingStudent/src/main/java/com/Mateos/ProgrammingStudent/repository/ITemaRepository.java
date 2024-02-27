package com.Mateos.ProgrammingStudent.repository;

import com.Mateos.ProgrammingStudent.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITemaRepository extends JpaRepository<Tema,Long> {
}
