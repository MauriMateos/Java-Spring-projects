package com.Mateos.VeterinaryClinic.service;

import com.Mateos.VeterinaryClinic.dto.PetOwnerDTO;
import com.Mateos.VeterinaryClinic.model.Owner;
import com.Mateos.VeterinaryClinic.repository.IOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OwnerService implements IOwnerService{

    @Autowired
    private IOwnerRepository ownerRepo;

    @Override
    public List<Owner> getOwners() {
        return ownerRepo.findAll();
    }

    @Override
    public void saveOwner(Owner owner) {
        ownerRepo.save(owner);
    }

    @Override
    public void deleteOwnerById(Long id) {
        ownerRepo.deleteById(id);
    }

    @Override
    public Owner findOwnerById(Long id) {
        return ownerRepo.findById(id).orElse(null);
    }

    @Override
    public void editOwner(Owner owner) {
        this.saveOwner(owner);
    }

    @Override
    public PetOwnerDTO getPetOwnerDTO(Long idOwner) {

        PetOwnerDTO petOwnDTO = new PetOwnerDTO();
        Owner owner = this.findOwnerById(idOwner);
        petOwnDTO.setPetName(owner.getPet().getName());
        petOwnDTO.setPetSpecies(owner.getPet().getSpecies());
        petOwnDTO.setPetBreed(owner.getPet().getBreed());
        petOwnDTO.setOwnerName(owner.getName());
        petOwnDTO.setOwnerLastName(owner.getLastName());
        return petOwnDTO;

    }
}
