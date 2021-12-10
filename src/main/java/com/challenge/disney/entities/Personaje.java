package com.challenge.disney.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.envers.Audited;

@Data
@Entity
@Table(name="Personaje")
@Audited
public class Personaje extends Base{
    
    @Column(name ="Imagen")
    private String imagen;
    
    @Column(name = "Nombre")
    private String nombre;
    
    @Column(name ="Edad")
    private Integer edad;
    
    @Column(name ="Peso")
    private Integer peso;
    
    @Column(name ="Historia")
    private String historia;  
    
    @ManyToOne
    @JoinColumn(name ="Pelicula_o_Serie")
    private  Pelicula_o_Serie pelicula_o_serie;
}
