
package com.challenge.disney.repositories;

import com.challenge.disney.entities.Personaje;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonajeRepository extends BaseRepository<Personaje, Long>{
    
    @Query("SELECT p.imagen, p.nombre FROM Personaje p")
    public List<Personaje> ListarPersonajes();
    
    @Query("SELECT p FROM Personaje p WHERE p.edad = :edad")
    public List<Personaje> PersonajePorEdad(@Param("edad")Integer edad);
    
    @Query("SELECT p FROM Personaje p WHERE p.nombre = :nombre")
    public List<Personaje> PersonajePorNombre(@Param("nombre") String nombre);   
    
     @Query("SELECT p FROM Personaje p WHERE p.pelicula_o_serie.id = :id")
    public List<Personaje> PersonajePorPelicula(@Param("id") Long IDmovie);   
}
