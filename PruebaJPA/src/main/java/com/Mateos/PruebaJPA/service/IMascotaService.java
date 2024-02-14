package com.Mateos.PruebaJPA.service;

import com.Mateos.PruebaJPA.model.Mascota;

import java.util.List;

public interface IMascotaService {
    //Traemos todas las mascotas
    //lectura
    public List<Mascota> getMascotas(); //todos los metodos de una interfaz son por defecto publicos

    //alta
    void saveMascota(Mascota masco);

    //baja
    void deleteMascota(Long idMascota);

    //lectura de un solo objeto
    Mascota findMascota(Long idMascota);

    void editMascota(Long idOriginal, Long idMascotaNueva,
                     String nuevoNombre,
                     String nuevaEspecie,
                     String nuevaRaza,
                     String nuevoColor);

}
