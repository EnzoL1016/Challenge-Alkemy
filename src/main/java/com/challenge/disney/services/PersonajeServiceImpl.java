package com.challenge.disney.services;

import com.challenge.disney.entities.Pelicula_o_Serie;
import com.challenge.disney.entities.Personaje;
import com.challenge.disney.repositories.PersonajeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonajeServiceImpl extends BaseServiceImpl<Personaje,Long>implements PersonajeService{
    
    @Autowired
    private PersonajeRepository personajeRepo;

    @Override
    public List<Personaje> listarPersonajes() throws Exception {
        List<Personaje> personajes = personajeRepo.ListarPersonajes();
        return personajes;
    }
    
    @Override
    public List<Personaje> listarPersonajePorNombre(String nombre) throws Exception{
        List<Personaje> personajes = personajeRepo.PersonajePorNombre(nombre);
        return personajes;
    }

    @Override
    public List<Personaje> listarPersonajePorEdad(Integer edad) throws Exception {
        List<Personaje> personajes = personajeRepo.PersonajePorEdad(edad);
        return personajes;
    }

    @Override
    public List<Personaje> listarPersonajePorPelicula(Long IDmovie) throws Exception {
        List<Personaje> personajes = personajeRepo.PersonajePorPelicula(IDmovie);
        return personajes;
    }
    
    
}
