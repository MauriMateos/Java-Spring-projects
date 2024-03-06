package com.api.crud.controller;

import com.api.crud.model.UserModel;
import com.api.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user") //esto es nuevo (para mi). Podemos ponerlo en app.properties pero lo ponemos aca para el tutorial
//TODO TODO TODO: Investigar para que sirve
public class UserController {
//en esta clase definimos las peticiones HTTP y sus rutas

//antes de crear esto, necesitamos crear el repositorio
//    @GetMapping("/getusers")

    @Autowired
    private UserService userService;

    @GetMapping //aca no ponemos ninguna ruta
    public ArrayList<UserModel> getUsers(){
        return this.userService.getUsers();
    }

    @PostMapping //tambien sin ruta
    public UserModel saveUser(@RequestBody UserModel user){//requestbody indica que vamos a enviar la request a traves del body en JSON
        return this.userService.saveUser(user);
    }

    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable("id") Long id){
        return this.userService.getById(id);
    }
    @PutMapping(path = "/{id}")
    public UserModel updateUserById(@RequestBody UserModel request, @PathVariable("id") Long id ){
        return this.userService.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){

        boolean ok = this.userService.deleteUser(id);
        if (ok){
            return "User with id "+id+" deleted succesfully";
        } else return "User Not found";
    }

}
