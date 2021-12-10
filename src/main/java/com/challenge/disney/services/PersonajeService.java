package com.challenge.disney.services;

import com.challenge.disney.entities.Personaje;
import java.util.List;

public interface PersonajeService extends BaseService<Personaje, Long> {
    public List<Personaje> listarPersonajes() throws Exception;
    public List<Personaje> listarPersonajePorNombre(String nombre) throws Exception;
    public List<Personaje> listarPersonajePorEdad(Integer edad) throws Exception;
    public List<Personaje> listarPersonajePorPelicula(Long IDmovie) throws Exception;
}
