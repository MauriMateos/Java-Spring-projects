package com.Mateos.VeterinaryClinic.service;

import com.Mateos.VeterinaryClinic.model.Owner;
import com.Mateos.VeterinaryClinic.model.Pet;
import com.Mateos.VeterinaryClinic.repository.IOwnerRepository;
import com.Mateos.VeterinaryClinic.repository.IPetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PetService implements IPetService{

    @Autowired
    private IPetRepository petRepo;



    @Override
    public List<Pet> getPets() {
        return petRepo.findAll();
    }

    @Override
    public void savePet(Pet pet) {
        petRepo.save(pet);
    }

    @Override
    public void deletePetById(Long id) {
        petRepo.deleteById(id);
    }

    @Override
    public Pet findPetById(Long id) {
        return petRepo.findById(id).orElse(null);
    }

    @Override
    public void editPet(Pet pet) {
        this.savePet(pet); //just basic editing when we edit the whole object
    }

    @Override
    public List<Pet> getPoodleDogs() {

        ///String word = "poodle";
        //String breed = "dog";
        //String compareText;

        List<Pet> petList = this.getPets();
        List<Pet> PoodlePetList = new ArrayList<>();

        for (Pet pet : petList){
            //compareText = pet.getBreed().toLowerCase();
            String species = pet.getSpecies().toLowerCase();
            String breed = pet.getBreed().toLowerCase();

            if (species.contains("dog") && breed.contains("poodle")){
                PoodlePetList.add(pet);
            }
        }


        return PoodlePetList;
    }
}
