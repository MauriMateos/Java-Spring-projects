package com.Mateos.VeterinaryClinic.service;

import com.Mateos.VeterinaryClinic.model.Pet;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IPetService {

    List<Pet> getPets();
    void savePet(Pet pet);
    void deletePetById(Long id);
    Pet findPetById(Long id);
    void editPet(Pet pet);

    List<Pet> getPoodleDogs(); // en pruebas

}
