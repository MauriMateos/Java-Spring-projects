package com.example.example1.and2.controller;

import com.example.example1.and2.Cliente;
import com.example.example1.and2.Plato;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AppController {

    //version con requestparam
    @GetMapping("restaurante/platos/traer")
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
//////////////////////////////////Odontologist////////////////////////

    @GetMapping("odontologo/pacientes/traer")
    @ResponseBody
    public List<Cliente> traerClientes(){
        List<Cliente> lista = new ArrayList<>();
        lista.add(new Cliente(1, "52333654", "Yasmín", "Romero", LocalDate.of(2016,8,18)));
        lista.add(new Cliente(2, "13558965", "Sara", "Barrios",LocalDate.of(1960,1,20)));
        lista.add(new Cliente(3, "49663221", "Benjamín", "Goichuk", LocalDate.of(2008,11,25)));
        lista.add(new Cliente(4, "50111889", "Gladys", "Andreiszyn", LocalDate.of(2015,9,27)));
        lista.add(new Cliente(5, "12000320", "Eduardo", "Malim", LocalDate.of(1958,5,13)));

        return lista;
    }

    @GetMapping("odontologo/pacientes/traer/menores")
    //@ResponseBody
    public List<Cliente> traerClientesMenores(){
        List<Cliente> lista = new ArrayList<>();
        lista.add(new Cliente(1, "52333654", "Yasmín", "Romero", LocalDate.of(2016,8,18)));
        lista.add(new Cliente(2, "13558965", "Sara", "Barrios",LocalDate.of(1960,1,20)));
        lista.add(new Cliente(3, "49663221", "Benjamín", "Goichuk", LocalDate.of(2008,11,25)));
        lista.add(new Cliente(4, "50111889", "Gladys", "Andreiszyn", LocalDate.of(2015,9,27)));
        lista.add(new Cliente(5, "12000320", "Eduardo", "Malim", LocalDate.of(1958,5,13)));

        List<Cliente> listaMenores = new ArrayList<>();
        for (Cliente cli : lista){

            LocalDate hoy = LocalDate.now();
            Period periodo = Period.between(cli.getFechaNacimiento(),hoy);
            int diferencia = periodo.getYears();

            if ( diferencia < 18){
                listaMenores.add(cli);
            }

        }
return listaMenores;
}
}
