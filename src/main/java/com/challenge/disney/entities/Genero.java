package com.challenge.disney.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.envers.Audited;


@Entity
@Table(name ="Género")
@Audited
@Data
public class Genero extends Base{
        
    @Column(name ="Nombre")
    private String nombre;
    
    @Column(name ="Imagen")
    private String imagen;   
    
    @OneToOne
    @JoinColumn(name ="Pelicula_o_Serie")
    private Pelicula_o_Serie pelicula_o_serie;
}
