package com.challenge.disney.auth.service;

import com.challenge.disney.auth.dto.UserDTO;
import com.challenge.disney.auth.entity.UserEntity;
import com.challenge.disney.auth.repository.UserRepository;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsCustomService implements UserDetailsService{
    
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmailService emailService;
    
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
       UserEntity userEntity = userRepository.findByUsername(userName);
       if(userEntity == null){
           throw new UsernameNotFoundException("Username or password not found");
       }
       return new User(userEntity.getUsername(), userEntity.getPassword(), Collections.emptyList());
    }
    
    public boolean save(UserDTO userDTO){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userDTO.getUsername());
        userEntity.setPassword(userDTO.getPassword());
        userEntity = this.userRepository.save(userEntity);
        if(userEntity != null){
            emailService.sendWelcomeEmailTo(userEntity.getUsername());
        }
        return userEntity != null;
    }
}
