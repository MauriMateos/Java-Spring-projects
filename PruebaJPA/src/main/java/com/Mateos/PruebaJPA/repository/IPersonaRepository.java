package com.Mateos.PruebaJPA.repository;

import com.Mateos.PruebaJPA.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // no olvidar Repository que es como le decimos a Spring que esto es un repository
public interface IPersonaRepository extends JpaRepository<Persona, Long> {//aclaramos tipo de clase y tipo de dato q es la primary key de esa clase, en este caso, Long
//con esto podemos acceder a todos los metodos JPA de Persona
}
