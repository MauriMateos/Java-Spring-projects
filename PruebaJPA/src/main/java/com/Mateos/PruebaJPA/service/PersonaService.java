package com.Mateos.PruebaJPA.service;

import com.Mateos.PruebaJPA.model.Persona;
import com.Mateos.PruebaJPA.repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService implements IPersonaService{
    @Autowired
    private IPersonaRepository persoRepo;

    @Override
    public List<Persona> getPersonas() {
        List<Persona> listaPersonas = persoRepo.findAll(); //encontrar todos, con metodo
        return listaPersonas;
    }

    @Override
    public void savePersona(Persona perso) {
        persoRepo.save(perso); //guardamos perso (esto funciona gracias a JPA repository)
    }

    @Override
    public void deletepersona(Long id) {
        persoRepo.deleteById(id); //borramos por id que nos pasan del controller
    }

    @Override
    public Persona findPersona(Long id) {
        Persona perso = persoRepo.findById(id).orElse(null); //o encontramos a la persona, o devolvemos null en caso de no encontrar
        return perso;
    }

    @Override
    public void editPersona(Long idOriginal, Long idNueva, String nuevoNombre, String nuevoApellido, int nuevaEdad) {
        //busco el objeto original
        Persona perso = this.findPersona(idOriginal);

        // proceso de modificacion a nivel logico
        perso.setId(idNueva);
        perso.setNombre(nuevoNombre);
        perso.setApellido(nuevoApellido);
        perso.setEdad(nuevaEdad);

        //guardar cambios
        this.savePersona(perso);
    }
}
