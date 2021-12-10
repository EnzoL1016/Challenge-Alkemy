package com.challenge.disney.controllers;

import com.challenge.disney.entities.Genero;
import com.challenge.disney.services.GeneroServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/genre")
public class GeneroController extends BaseControllerImpl<Genero,GeneroServiceImpl>{
    
}
