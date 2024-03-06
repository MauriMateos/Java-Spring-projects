package com.Mateos.VeterinaryClinic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PetOwnerDTO {

    private String petName;
    private String petSpecies;
    private String petBreed;
    private String ownerName;
    private String ownerLastName;

}
