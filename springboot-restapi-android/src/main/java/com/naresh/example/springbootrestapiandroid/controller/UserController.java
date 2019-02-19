package com.naresh.example.springbootrestapiandroid.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.naresh.example.springbootrestapiandroid.model.User;
import com.naresh.example.springbootrestapiandroid.repository.UserRepository;

@RestController
@ResponseBody
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	/*   @PostMapping("/user")
	    public User createEmployee(@Valid @RequestBody User user) {
	        return userRepository.save(user);
	   }*/
	
	
	/*		@PostMapping("/user")
		    public ResponseEntity<Object> createEmployee(@Valid @RequestBody User user) {
		         userRepository.save(user);
		         URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
							.buildAndExpand(user.getId()).toUri();
		         return ResponseEntity.created(location).build();
		         }
			 	*/
	  @PostMapping("/user")   
	    public ResponseEntity<Object> createUsers(@Valid @RequestBody User user) {
	         userRepository.save(user);
	         return new ResponseEntity<>("success",HttpStatus.OK);
	    } 
	  @GetMapping("/retrieve")
	  public List<User> retrieveUsers(){
		  return userRepository.findAll(); 
	  }

}