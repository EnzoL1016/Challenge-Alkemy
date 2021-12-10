
package com.challenge.disney.services;

import com.challenge.disney.entities.Pelicula_o_Serie;
import java.util.List;


public interface Pelicula_o_SerieService  extends BaseService<Pelicula_o_Serie,Long>{
    public List<Pelicula_o_Serie> listarPeliculas() throws Exception;
    public List<Pelicula_o_Serie> listarPeliculaPorNombre(String titulo) throws Exception;
    public List<Pelicula_o_Serie> listarPeliculaPorGenero(Long generoID) throws Exception;
    public List<Pelicula_o_Serie> listarPeliculaAsc() throws Exception;
    public List<Pelicula_o_Serie> listarPeliculaDesc() throws Exception;
}
