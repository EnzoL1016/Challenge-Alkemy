
package com.challenge.disney.controllers;

import com.challenge.disney.entities.Pelicula_o_Serie;
import com.challenge.disney.entities.Personaje;
import com.challenge.disney.services.PersonajeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/character")
public class PersonajeController  extends BaseControllerImpl<Personaje, PersonajeServiceImpl>{
    
    @Autowired
    private PersonajeServiceImpl personajeService;
    
    @GetMapping("/characters")
    public ResponseEntity <?> Listar(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personajeService.listarPersonajes());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, Please try again later.\"}");
        }
    }
    
    @GetMapping("/characters?name={nombre}")
    public ResponseEntity <?> ListarPorNombre(@PathVariable String nombre){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personajeService.listarPersonajePorNombre(nombre));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, Please try again later.\"}");
        }
    }
    
    @GetMapping("/characters?age={edad}")
    public ResponseEntity <?> ListarPorEdad(@PathVariable Integer edad){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personajeService.listarPersonajePorEdad(edad));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, Please try again later.\"}");
        }
    }
    
    @GetMapping("/characters?movies={IDmovie}")
    public ResponseEntity <?> ListarPorEdad(@PathVariable Long IDmovie){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personajeService.listarPersonajePorPelicula(IDmovie));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, Please try again later.\"}");
        }
    }
 
}
