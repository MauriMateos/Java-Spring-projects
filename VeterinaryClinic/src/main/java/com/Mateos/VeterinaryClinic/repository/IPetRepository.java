package com.Mateos.VeterinaryClinic.repository;

import com.Mateos.VeterinaryClinic.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPetRepository extends JpaRepository<Pet,Long> {
}
