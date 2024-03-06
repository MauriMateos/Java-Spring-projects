package com.api.crud.service;

import com.api.crud.model.UserModel;
import com.api.crud.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    @Autowired // usamos autowired para inyeccion de dependencias, ese caso IUserRepository
    IUserRepository userRepository;

    public ArrayList<UserModel>getUsers(){ //devuelve un arraylist del generico UserModel
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public UserModel saveUser(UserModel user){ //aca guardamos un usuario
        return userRepository.save(user);
    }

    public Optional<UserModel> getById(Long id){ //el tipo optional puede devolver algo o si no, NULL
        return userRepository.findById(id);
    }

    public UserModel updateById(UserModel request, Long id){ //aca parece que un optional no funciona (el tipo tiene tanta idea como yo)
        UserModel user = userRepository.findById(id).get();  //esto, al ser un PUT, cambiamos todos los datos, si no, seria un PATCH
                user.setFirstName(request.getFirstName());
                user.setLastName(request.getLastName());
                user.setEmail(request.getEmail());
        return user;
    }

    public Boolean deleteUser (Long id){
        try{
            userRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
