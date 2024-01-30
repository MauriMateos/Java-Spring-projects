package com.example.autowiredTest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Posteo {
    private Long id;
    private String titulo;
    private String autor;


}
