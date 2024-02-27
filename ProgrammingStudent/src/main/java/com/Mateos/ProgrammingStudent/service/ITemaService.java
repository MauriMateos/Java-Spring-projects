package com.Mateos.ProgrammingStudent.service;


import com.Mateos.ProgrammingStudent.model.Tema;

import java.util.List;

public interface ITemaService {

     List<Tema> getTemas();


     void saveTema(Tema tema);


     void deleteTema(Long id);


     Tema findTema(Long id);

     void editTema(Tema tema);
}
