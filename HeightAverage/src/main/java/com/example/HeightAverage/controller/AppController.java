package com.example.HeightAverage.controller;

import com.example.HeightAverage.model.Jugador;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppController {
    @PostMapping("/listarAlturas")
    public String calcularPromedio (@RequestBody List<Jugador> listaJugadores){

        double sumaEstaturas = 0;
        double promedioTotal;

        List<Jugador> listaJugadorLogica = listaJugadores; // redunda pero simulamos una bd logica

        for (Jugador jug : listaJugadorLogica){
            sumaEstaturas = sumaEstaturas + jug.getEstatura();
        }

        promedioTotal = sumaEstaturas/listaJugadorLogica.size();
        return "promedio de estaturas: " + promedioTotal;
    }
}
