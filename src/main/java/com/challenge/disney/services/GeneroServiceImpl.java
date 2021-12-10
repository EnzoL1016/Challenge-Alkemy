package com.challenge.disney.services;

import com.challenge.disney.entities.Genero;
import com.challenge.disney.repositories.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GeneroServiceImpl extends BaseServiceImpl<Genero,Long>implements GeneroService{
    
    @Autowired
    private GeneroRepository generoRepo;
  
}
