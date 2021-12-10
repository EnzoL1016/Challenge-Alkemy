package com.challenge.disney.services;

import com.challenge.disney.entities.Genero;
import com.challenge.disney.entities.Pelicula_o_Serie;
import com.challenge.disney.repositories.Pelicula_o_SerieRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Pelicula_o_SerieServicesImpl extends BaseServiceImpl<Pelicula_o_Serie,Long>implements Pelicula_o_SerieService{

    @Autowired
    private Pelicula_o_SerieRepository pelioserieRepo;

    @Override
    public List<Pelicula_o_Serie> listarPeliculas() throws Exception {
        List<Pelicula_o_Serie> pelicula_o_serie = pelioserieRepo.listarPeliculas();
        return pelicula_o_serie;
    }

    @Override
    public List<Pelicula_o_Serie> listarPeliculaPorNombre(String titulo) throws Exception {
        List<Pelicula_o_Serie> movies = pelioserieRepo.peliculaPorNombre(titulo);
        return movies;
    }

    @Override
    public List<Pelicula_o_Serie> listarPeliculaPorGenero(Long generoID) throws Exception {
        List<Pelicula_o_Serie> movies = pelioserieRepo.peliculaPorGenero(generoID);
        return movies;
    }

    @Override
    public List<Pelicula_o_Serie> listarPeliculaAsc() throws Exception {
        List<Pelicula_o_Serie> movies = pelioserieRepo.peliculaOrdenAsc();
        return movies;
    }

    @Override
    public List<Pelicula_o_Serie> listarPeliculaDesc() throws Exception {
        List<Pelicula_o_Serie> movies = pelioserieRepo.peliculaOrdenDesc();
        return movies;
    }
    
    
}
