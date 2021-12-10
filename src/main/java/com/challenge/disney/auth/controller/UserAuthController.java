package com.challenge.disney.auth.controller;

import com.challenge.disney.auth.dto.AuthenticationRequest;
import com.challenge.disney.auth.dto.AuthenticationResponse;
import com.challenge.disney.auth.dto.UserDTO;
import com.challenge.disney.auth.service.JwtUtils;
import com.challenge.disney.auth.service.SigninService;
import com.challenge.disney.auth.service.UserDetailsCustomService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/auth")
public class UserAuthController {

    private UserDetailsCustomService userDetailsService;
    private AuthenticationManager authenticationManager;
    private JwtUtils jwtTokenUtil;
    @Autowired
    private SigninService signinService;

    @Autowired
    public UserAuthController(
            UserDetailsCustomService userDetailsService,
            AuthenticationManager authenticationManager,
            JwtUtils jwtTokenUtil) {
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
    }
    
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> signup(@Valid @RequestBody UserDTO user)throws Exception{
        this.userDetailsService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> signin(@RequestBody AuthenticationRequest authRequest)throws Exception{
      return signinService.signin(authRequest);
    }
}
