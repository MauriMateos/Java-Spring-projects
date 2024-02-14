package com.Mateos.PruebaJPA.controller;

import com.Mateos.PruebaJPA.model.Persona;
import com.Mateos.PruebaJPA.service.IPersonaService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonaController {
    @Autowired // inyectamos dependencia mediante autowired
    private IPersonaService persoServ; //implementamos la interfaz


    //traemos todas las personas mediante GetMapping
    @GetMapping("/personas/traer")
    public List<Persona> getPersonas() { //esto tiene que devolver una response
        return persoServ.getPersonas(); //va al repositorio y trae la lista de personas y aqui respondemos
    }

    //alta de personas mediante PostMapping
    @PostMapping("/personas/crear")
    public String savePersona(@RequestBody Persona perso) { //recibimos en el cuerpo de la solicitud todos los datos, va a llegar mediante json una persona
        persoServ.savePersona(perso);
        return "La persona fue creada correctamente";
    }

    //baja de personas mediante DeleteMapping y el id mediante pathvariable
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id) {
        persoServ.deletepersona(id);
        return "Persona eliminada correctamente";//una vez borrado el id, muestra mensaje mediante return
    }

    //modificacion de personas mediante PutMapping y path variable
    @PutMapping("/personas/editar/{id_original}")
    public Persona editPersona(@PathVariable Long id_original,
                               @RequestParam(required = false, name = "id") Long nuevaId, //cambiar el ID es mala practica pero puede pasar que se necesite
                               @RequestParam(required = false, name = "nombre") String nuevoNombre,
                               @RequestParam(required = false, name = "apellido") String nuevoApellido,
                               @RequestParam(required = false, name = "edad") int nuevaEdad) {

        persoServ.editPersona(id_original, nuevaId, nuevoNombre, nuevoApellido, nuevaEdad); //tomamos esto y se lo mandamos a editpersona
    Persona perso = persoServ.findPersona(nuevaId); //creamos nueva persona y buscamos la persona con id nuevo
        return perso;
    }

    @PutMapping("/personas/editar") //otra manera de editar con el objeto entero, el ID ES INTOCABLE!
    public Persona editPersona(@RequestBody Persona perso){ // aca lo hacemos con requestbody, no por URL como los demas
        persoServ.editPersona(perso);
        return persoServ.findPersona(perso.getId());
    }


}
