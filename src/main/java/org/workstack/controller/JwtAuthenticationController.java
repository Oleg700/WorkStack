package org.workstack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.workstack.security.model.JwtRequest;
import org.workstack.security.model.JwtResponse;
import org.workstack.security.service.JwtTokenService;

@RestController
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(
            @RequestBody JwtRequest request) throws Exception {
        authenticate(request.getUsername(), request.getPassword());
        UserDetails userDetails = userDetailsService.
                loadUserByUsername(request.getUsername());
        String token = jwtTokenService.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String pasword) {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, pasword));
    }
}
