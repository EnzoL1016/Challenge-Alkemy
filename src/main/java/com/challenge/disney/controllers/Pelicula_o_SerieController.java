package com.challenge.disney.controllers;

import com.challenge.disney.entities.Pelicula_o_Serie;
import com.challenge.disney.services.Pelicula_o_SerieServicesImpl;
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
@RequestMapping(path = "/movie")
public class Pelicula_o_SerieController extends BaseControllerImpl<Pelicula_o_Serie,Pelicula_o_SerieServicesImpl>{
    
    @Autowired(required = true)
    private Pelicula_o_SerieServicesImpl peliServices;
    
    @GetMapping("/movies")
    public ResponseEntity <?> Listar(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(peliServices.listarPeliculas());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, Please try again later.\"}");
        }
    }
    @GetMapping("/movies?name={titulo}")
    public ResponseEntity <?> ListarPorNombre(@PathVariable String titulo){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(peliServices.listarPeliculaPorNombre(titulo));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, Please try again later.\"}");
        }
    }
    
    @GetMapping("/movies?name={idGenero}")
    public ResponseEntity <?> ListarPorGenero(@PathVariable Long IDgenero){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(peliServices.listarPeliculaPorGenero(IDgenero));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, Please try again later.\"}");
        }
    }
    
    @GetMapping("/movies?order=ASC")
    public ResponseEntity <?> ListarPirOrdenASC(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(peliServices.listarPeliculaAsc());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, Please try again later.\"}");
        }
    }
    
    @GetMapping("/movies?order=DESC")
    public ResponseEntity <?> ListarPirOrdenDESC(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(peliServices.listarPeliculaDesc());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, Please try again later.\"}");
        }
    }
}
