package com.Mateos.VeterinaryClinic.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Long dni;
    private String name;
    private String lastName; //apellido
    private String phoneNum;
    @OneToOne
    @JoinColumn(name = "pet", referencedColumnName = "id")
    private Pet pet;
}
