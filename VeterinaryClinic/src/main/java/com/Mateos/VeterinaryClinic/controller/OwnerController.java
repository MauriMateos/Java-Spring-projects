package com.Mateos.VeterinaryClinic.controller;

import com.Mateos.VeterinaryClinic.dto.PetOwnerDTO;
import com.Mateos.VeterinaryClinic.model.Owner;
import com.Mateos.VeterinaryClinic.service.IOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OwnerController {

    @Autowired
    private IOwnerService ownerServ;

    //crear nuevo Owner
    @PostMapping("/owner/create")
    public String createOwner(@RequestBody Owner owner){ //le pasamos el json por el body de la request
        ownerServ.saveOwner(owner);
        return "Owner creation succesful";
    }


    //obtain all owners
    @GetMapping("/owner/get")
    public List<Owner> getOwners(){
        return ownerServ.getOwners();
    }

    @GetMapping("/owner/id/{id}") //get owner by id
    public Owner getOwnerById(@PathVariable Long id){ ///testing
        return ownerServ.findOwnerById(id);
    }

    @PutMapping("/owner/edit") //edit owner
    public String editOwner(@RequestBody Owner owner){
        ownerServ.editOwner(owner);
        return "Owner editing success";
    }

    @DeleteMapping("/owner/id/{id}") // delete owner by id
    public String deleteOwnerById(@PathVariable Long id){
        ownerServ.deleteOwnerById(id);
        return "Owner deletion success";
    }

    @GetMapping("/owner/dto/{id}")
    public PetOwnerDTO ownerDTOById(@PathVariable Long id){

        return ownerServ.getPetOwnerDTO(id);

    }

}
