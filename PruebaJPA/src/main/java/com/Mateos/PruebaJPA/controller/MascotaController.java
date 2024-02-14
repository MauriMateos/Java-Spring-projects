package com.Mateos.PruebaJPA.controller;

import com.Mateos.PruebaJPA.model.Mascota;
import com.Mateos.PruebaJPA.model.Persona;
import com.Mateos.PruebaJPA.service.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MascotaController {
    @Autowired
    private IMascotaService mascoServ;

    @PostMapping("/mascotas/crear")
    public String saveMascota(@RequestBody Mascota masco) { //recibimos en el cuerpo de la solicitud todos los datos, va a llegar mediante json una mascota
        mascoServ.saveMascota(masco);
        return "La mascota fue creada correctamente";
    }
}
