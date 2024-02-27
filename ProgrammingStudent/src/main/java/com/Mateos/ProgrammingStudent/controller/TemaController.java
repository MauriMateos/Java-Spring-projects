package com.Mateos.ProgrammingStudent.controller;

import com.Mateos.ProgrammingStudent.model.Tema;
import com.Mateos.ProgrammingStudent.service.ITemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemaController {

    @Autowired
    private ITemaService temaServ;

    @PostMapping("/temas/crear")
    public String crearCurso(@RequestBody Tema tema){
        temaServ.saveTema(tema);
        return "Tema creado correctamente";
    }

    @PutMapping("/tema/edit")
    public String editTema(@RequestBody Tema tema){
        temaServ.editTema(tema);
        return "Tema creado correctamente";
    }

}
