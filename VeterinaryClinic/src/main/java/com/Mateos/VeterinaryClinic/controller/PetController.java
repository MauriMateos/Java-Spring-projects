package com.Mateos.VeterinaryClinic.controller;

import com.Mateos.VeterinaryClinic.model.Pet;
import com.Mateos.VeterinaryClinic.service.IOwnerService;
import com.Mateos.VeterinaryClinic.service.IPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PetController {

    @Autowired
    private IPetService petServ;



    @PostMapping("/pet/create")
    public String createPet(@RequestBody Pet pet){ //le pasamos el json por el body de la request

        petServ.savePet(pet);
        return "Pet creation succesful";
    }


    //obtain all Pets
    @GetMapping("/pet/get")
    public List<Pet> getPets(){
        return petServ.getPets();
    }

    @GetMapping("/pet/id/{id}") //get Pet by id
    public Pet getPetById(@PathVariable Long id){ ///testing
        return petServ.findPetById(id);
    }

    @PutMapping("/pet/edit") //edit Pet
    public String editPet(@RequestBody Pet Pet){
        petServ.editPet(Pet);
        return "Pet editing success";
    }

    @DeleteMapping("/pet/deletebyid/{id}") // delete Pet by id
    public String deletePetById(@PathVariable Long id){
        petServ.deletePetById(id);
        return "Pet deletion success";
    }

    @GetMapping("/pet/poodle")
    public List<Pet> poodlePetList(){
        return petServ.getPoodleDogs();
    }
    
}
