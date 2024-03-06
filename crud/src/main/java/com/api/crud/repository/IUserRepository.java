package com.api.crud.repository;

import com.api.crud.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Un repositorio es una clase que permite hacer queries o consultas a una base de datos
//aca usamos JPA repository para hacer algunas consultas predefinidas por defecto
@Repository
public interface IUserRepository extends JpaRepository<UserModel, Long> {
}
