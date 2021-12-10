
package com.challenge.disney.repositories;

import com.challenge.disney.entities.Pelicula_o_Serie;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Pelicula_o_SerieRepository extends BaseRepository <Pelicula_o_Serie, Long> {
    
    @Query("SELECT p.imagen, p.titulo, p.fecha_creacion FROM Pelicula_o_Serie p")
    public List<Pelicula_o_Serie> listarPeliculas();
    
      @Query("SELECT p FROM Pelicula_o_Serie p WHERE p.titulo = :titulo")
    public List<Pelicula_o_Serie> peliculaPorNombre(@Param("titulo")String titulo);
    
    @Query("SELECT p FROM Pelicula_o_Serie p WHERE p.genero.id = :id")
    public List<Pelicula_o_Serie> peliculaPorGenero(@Param("id") Long generoId);   
    
     @Query("SELECT p FROM Pelicula_o_Serie p ORDER BY p.titulo ASC")
    public List<Pelicula_o_Serie> peliculaOrdenAsc(); 
    
    @Query("SELECT p FROM Pelicula_o_Serie p ORDER BY p.titulo DESC")
    public List<Pelicula_o_Serie> peliculaOrdenDesc();  
}
