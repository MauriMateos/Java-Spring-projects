package com.example.autowiredTest.repository;

import com.example.autowiredTest.model.Posteo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PosteoRepository implements IPosteoRepository{

    @Override
    public List<Posteo> traerTodos() {
        List<Posteo> listaPosteos = new ArrayList<Posteo>();
        listaPosteos.add(new Posteo(1L, "Como formatear una pc", "Luisina"));
        listaPosteos.add(new Posteo(2L,"Como mantener la seguridad", "Alfred"));
        return listaPosteos;
    }
}
