package com.api.crud.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user") // usamos esta annotation para crear la tabla con ese nombre y no usar el nombre de la clase
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //tanto AUTO como IDENTITY funcionarian en este caso (i dunno)
    private Long id;

    @Column //decimos que esto es una columna, esto lo hace automaticamente, aca la dejamos igual.
    private String firstName; //SQL pasa el camelCase a guion bajo, (camel_case)

    @Column
    private String lastName;

    @Column
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
