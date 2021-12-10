package com.challenge.disney.controllers;

import com.challenge.disney.entities.Base;
import com.challenge.disney.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class BaseControllerImpl <E extends Base,S extends BaseServiceImpl <E,Long> > implements BaseController<E,Long>{
   @Autowired
   protected S service;
   
    @GetMapping("/list")
    @Override
    public ResponseEntity <?> getAll(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, Please try again later.\"}");
        }
    }
    
    @GetMapping("/list/{id}")
    @Override
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, Please try again later.\"}");
        }
    }
    
    @PostMapping("/load")
    @Override
    public ResponseEntity <?> save(@RequestBody E entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.save(entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, Please try again later.\"}");
        }
    }
    
    @PutMapping("/modify/{id}")
    @Override
    public ResponseEntity <?> update(@PathVariable Long id, @RequestBody E entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.update(id, entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, Please try again later.\"}");
        }
    }
    
    @DeleteMapping("/delete/{id}")
    @Override
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, Please try again later.\"}");
        }
    }
}
