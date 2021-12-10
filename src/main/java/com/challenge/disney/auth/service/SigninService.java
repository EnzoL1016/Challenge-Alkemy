package com.challenge.disney.auth.service;

import com.challenge.disney.auth.dto.AuthenticationRequest;
import com.challenge.disney.auth.dto.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class SigninService {

    private UserDetailsCustomService userDetailsService;
    private AuthenticationManager authenticationManager;
    private JwtUtils jwtTokenUtil;

    @Autowired
    public SigninService(
            UserDetailsCustomService userDetailsService,
            AuthenticationManager authenticationManager,
            JwtUtils jwtTokenUtil) {
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    public ResponseEntity<AuthenticationResponse> signin(AuthenticationRequest authRequest) throws Exception {
        UserDetails userDetails;
        try {
            org.springframework.security.core.Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
            userDetails = (UserDetails) auth.getPrincipal();
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
