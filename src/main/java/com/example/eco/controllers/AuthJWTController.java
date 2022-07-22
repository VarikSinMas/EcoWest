package com.example.eco.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.eco.UsuarioServices.CustomUsuarioDetailsService;
import com.example.eco.config.JwtTokenUtil;
import com.example.eco.models.JwtRequest;
import com.example.eco.models.JwtResponse;
import com.example.eco.models.UsuarioDTO;

@RestController
@CrossOrigin
public class AuthJWTController {
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private CustomUsuarioDetailsService customUsuarioDetailsService;
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		
		authenticate(authenticationRequest.getNickname(), authenticationRequest.getPassword());

		 UserDetails userDetails = customUsuarioDetailsService.loadUserByUsername(authenticationRequest.getNickname());


		final String token = jwtTokenUtil.generateToken(userDetails, customUsuarioDetailsService.loadUserByUsernameJWT(authenticationRequest.getNickname()));

		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UsuarioDTO user) throws Exception {
		return ResponseEntity.ok(customUsuarioDetailsService.save(user));
	}
	private void authenticate(String nickname, String password) throws Exception {
		try {
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(nickname, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
