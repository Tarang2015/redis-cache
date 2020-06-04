package com.ibs.redis.rediscache.controller;

import com.ibs.redis.rediscache.config.JwtToken;
import com.ibs.redis.rediscache.model.JwtRequest;
import com.ibs.redis.rediscache.model.JwtResponse;
import com.ibs.redis.rediscache.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private JwtToken jwtToken;

  @Autowired
  private JwtUserDetailsService jwtUserDetailsService;


  @PostMapping("/authenticate")
  public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {


    authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

    final UserDetails userDetails = jwtUserDetailsService

        .loadUserByUsername(authenticationRequest.getUsername());

    final String token = jwtToken.generateToken(userDetails);

    return ResponseEntity.ok(new JwtResponse(token));

  }

  private void authenticate(String username, String password) throws Exception {

    try {

      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

    } catch (DisabledException e) {

      throw new Exception("USER_DISABLED", e);

    } catch (BadCredentialsException e) {

      throw new Exception("INVALID_CREDENTIALS", e);

    }

  }

}