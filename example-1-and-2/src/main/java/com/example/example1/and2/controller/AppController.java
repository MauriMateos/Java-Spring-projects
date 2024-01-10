package com.example.example1.and2.controller;

import com.example.example1.and2.Plato;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AppController {

    //version con requestparam
    @GetMapping("platos/traer")
    //@ResponseBody
    public Plato traerPlato(@RequestParam("idPlato") int idPlato){
        idPlato--;
        List<Plato> listaPlatos = new ArrayList<Plato>();
        listaPlatos.add(new Plato(1,"pollo a las hierbas",250d,"pollo cocinado a la plancha con romero y limon"));
        listaPlatos.add(new Plato(2,"res a las hierbas",350d,"res cocinado a la plancha con romero y limon"));
        listaPlatos.add(new Plato(3,"cerdo a las hierbas",550d,"cerdo cocinado a la plancha con romero y limon"));
        listaPlatos.add(new Plato(4,"asado",720d,"asado con chori y ensalada"));
        listaPlatos.add(new Plato(5,"caviar",125000d,"huevos de pez, una delisssia"));

        return listaPlatos.get(idPlato);

    }
    //version con pathvariable
    @GetMapping("/plato/{idPlato}")
    public Plato traerPlatos(@PathVariable int idPlato){
        idPlato--;
        List<Plato> listaPlatos = new ArrayList<Plato>();
        listaPlatos.add(new Plato(1,"pollo a las hierbas",250d,"pollo cocinado a la plancha con romero y limon"));
        listaPlatos.add(new Plato(2,"res a las hierbas",350d,"res cocinado a la plancha con romero y limon"));
        listaPlatos.add(new Plato(3,"cerdo a las hierbas",550d,"cerdo cocinado a la plancha con romero y limon"));
        listaPlatos.add(new Plato(4,"asado",720d,"asado con chori y ensalada"));
        listaPlatos.add(new Plato(5,"caviar",125000d,"huevos de pez, una delisssia"));

        return listaPlatos.get(idPlato);

    }

}
