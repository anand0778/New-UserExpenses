package com.sintoli.Controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogBuilder;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sintoli.entity.AuthModel;
import com.sintoli.entity.User;
import com.sintoli.entity.UserModel;
import com.sintoli.service.UserService;

@RestController
public class AuthController {
	//private static final LogBuilder logger=(LogBuilder) LogManager.getLogger(AuthController.class);
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userService;

//	@PostMapping("/login")
//	public ResponseEntity<String>  login()
//	{
//	return new ResponseEntity<String>("User is logged in",HttpStatus.OK);
//	} 
	
	
	@PostMapping("/register")
	public ResponseEntity<User> save(@Valid @RequestBody UserModel user){
		
	return	new ResponseEntity<User>(userService.createUser(user),HttpStatus.CREATED);
		
	}

	@PostMapping("/login")
	public ResponseEntity<HttpStatus> login(@RequestBody AuthModel authModel)
	{
	Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authModel.getEmail(),authModel.getPassword()));
	SecurityContextHolder.getContext().setAuthentication(authentication);
	return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	} 
//	
//	
//	@PostMapping("/register")
//	public ResponseEntity<User> save(@Valid @RequestBody UserModel user){
//		
//	return	new ResponseEntity<User>(userService.createUser(user),HttpStatus.CREATED);
//		
//	}
}
