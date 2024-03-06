package com.Mateos.VeterinaryClinic.repository;

import com.Mateos.VeterinaryClinic.model.Owner;
import com.Mateos.VeterinaryClinic.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOwnerRepository extends JpaRepository<Owner,Long> {
}
