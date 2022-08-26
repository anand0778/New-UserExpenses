package com.sintoli.Controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogBuilder;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sintoli.entity.User;
import com.sintoli.entity.UserModel;
import com.sintoli.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> get(@PathVariable Long id) {
		return new ResponseEntity<User>(userService.read(id),HttpStatus.OK);
		
	}
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable Long  id){
		User mUser=userService.update(user, id);
	return new ResponseEntity<User>(mUser, HttpStatus.CREATED);
		
	}
	@DeleteMapping("/users/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable Long  id){
		userService.delete(id);
	return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		
	}
}
