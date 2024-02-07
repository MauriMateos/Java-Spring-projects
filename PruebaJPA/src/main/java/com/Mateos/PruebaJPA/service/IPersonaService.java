package com.Mateos.PruebaJPA.service;

import com.Mateos.PruebaJPA.model.Persona;
import com.Mateos.PruebaJPA.repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IPersonaService {

    //metodo para traer todas las personas
    //lectura
     List<Persona> getPersonas();

    //alta
 void savePersona(Persona perso);

//baja
     void deletepersona(Long id);
//lectura de un solo objeto
    Persona findPersona(Long id);

    //edicion/modificacion
    void editPersona(Long idOriginal, Long idNueva, String nuevoNombre, String nuevoApellido, int nuevaEdad);


}
