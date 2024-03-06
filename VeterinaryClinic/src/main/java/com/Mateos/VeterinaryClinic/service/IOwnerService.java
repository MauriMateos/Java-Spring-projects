package com.Mateos.VeterinaryClinic.service;


import com.Mateos.VeterinaryClinic.dto.PetOwnerDTO;
import com.Mateos.VeterinaryClinic.model.Owner;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IOwnerService {
    //Remember that everything here is public

    List<Owner> getOwners();  // gets all the owners
    void saveOwner(Owner owner);
    void deleteOwnerById(Long id);
    Owner findOwnerById(Long id);
    void editOwner(Owner owner);


     //en pruebas

    PetOwnerDTO getPetOwnerDTO(Long idOwner);
}
