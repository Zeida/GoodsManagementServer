package com.serverbitboxer2.serverbitboxer2.controller;

import com.serverbitboxer2.serverbitboxer2.configurations.JwtTokenUtil;
import com.serverbitboxer2.serverbitboxer2.dto.UserDTO;
import com.serverbitboxer2.serverbitboxer2.entities.JwtRequest;
import com.serverbitboxer2.serverbitboxer2.entities.JwtResponse;
import com.serverbitboxer2.serverbitboxer2.services.JwtUserDetailsService;
import com.serverbitboxer2.serverbitboxer2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token, userDetails.getUsername()));
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void saveUser(@RequestBody UserDTO userDTO) throws Exception {
        try {
            userDetailsService.save(userDTO);
        } catch (RuntimeException e){
        throw new Exception("This user (" + userDTO.getUsername() + ") already exist");
        }
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("This user is disabled.", e);
        } catch (BadCredentialsException e) {
            throw new Exception("Your credentials are wrong.", e);
        }
    }
}