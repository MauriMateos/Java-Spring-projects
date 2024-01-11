package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class appController {

    @GetMapping("/propiedad/{id}")
    @ResponseBody
    public PropiedadDTO traerPropiedad(@PathVariable Long id){

        Inquilino inqui = new Inquilino(1L, "36234854", "Rodrigo", "Valente","Peletero");
        Propiedad propi = new Propiedad(12L,"departamento","barbados 7042",1530.0,220000d);

        PropiedadDTO propiDTO = new PropiedadDTO();
        propiDTO.setIdPropiedad(propi.getIdPropiedad());
        propiDTO.setTipoPropiedad(propi.getTipoPropiedad());
        propiDTO.setDireccion(propi.getDireccion());
        propiDTO.setValorAlquiler(propi.getValorAlquiler());
        propiDTO.setNombre(inqui.getNombre());
        propiDTO.setApellido(inqui.getApellido());

        return propiDTO;
    }

}
