package com.challenge.disney.entities;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import org.hibernate.envers.Audited;

@Data
@Entity
@Table(name ="Pelicula_o_Serie")
@Audited
public class Pelicula_o_Serie extends Base {
   
    
    @Column(name ="Imagen")
    private String imagen;
    
    @Column(name ="Titulo")
    private String titulo;    
    
    @Temporal(TemporalType.DATE)
    @Column(name ="Fecha_Creación")
    private Date fecha_creacion;
    
    @Column(name ="Calificación")
    private Integer calificacion;
    
    @OneToMany
    @JoinColumn(name ="Personajes_Asociados")
    private List<Personaje> personajes_asociados;
    
    @OneToOne
    @JoinColumn(name = "Género")
    private Genero genero;
}
