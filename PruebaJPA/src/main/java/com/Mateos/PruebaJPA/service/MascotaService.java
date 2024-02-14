package com.Mateos.PruebaJPA.service;

import com.Mateos.PruebaJPA.model.Mascota;
import com.Mateos.PruebaJPA.repository.IMascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //marcamos que es nuestra clase servicio
public class MascotaService implements IMascotaService {

    @Autowired //no olvidarse de autowired para inyeccion de dependencias
    private IMascotaRepository repoMasco; //con esto vamos a poder acceder a los metodos

    @Override
    public List<Mascota> getMascotas() {
        List<Mascota> listaMascotas = repoMasco.findAll();
        return listaMascotas;
    }

    @Override
    public void saveMascota(Mascota masco) {
        repoMasco.save(masco);
    }

    @Override
    public void deleteMascota(Long idMascota) {
        repoMasco.deleteById(idMascota);
    }

    @Override
    public Mascota findMascota(Long idMascota) {
        return repoMasco.findById(idMascota).orElse(null);
    }

    @Override
    public void editMascota(Long idOriginal, Long idMascotaNueva, String nuevoNombre, String nuevaEspecie, String nuevaRaza, String nuevoColor) {

        //busco el objeto original
        Mascota masco = this.findMascota(idOriginal);

        //proceso de modificacion a nivel logico
        masco.setIdMascota(idMascotaNueva);
        masco.setNombre(nuevoNombre);
        masco.setEspecie(nuevaEspecie);
        masco.setRaza(nuevaRaza);
        masco.setColor(nuevoColor);

        //finalmente guardamos los cambios
        this.saveMascota(masco); //aqui hacemos referencia a la misma clase con this y guardamos el objeto mascota nuevo
    } //implementa IMascotaService


}
