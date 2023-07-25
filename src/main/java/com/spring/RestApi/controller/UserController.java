package com.spring.RestApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.RestApi.exception.UserNotFoundException;
import com.spring.RestApi.model.User;
import com.spring.RestApi.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService us;
//	@RequestMapping("/api")
//	public void exception() throws UserNotFoundException
//	{
//		throw new UserNotFoundException("user not found");
//	}
	@PostMapping("/saveUser")
	public ResponseEntity saveUser(@RequestBody User u) throws UserNotFoundException
	{
		User user=us.saveUser(u);
		return new ResponseEntity<>(user,HttpStatus.CREATED);
		
	}
	@GetMapping("/getUsers")
	public List<User>getUsers()
	{
		List<User>ulist=us.getUsers();
		return ulist;
	}
	@GetMapping("/getUser/{username}")
	public User getUser(@PathVariable String username) throws UserNotFoundException
	{
		User user=us.getUser(username);
		return user;
	}
	@PutMapping("/updateUser/{username}")
	public User updateUser(@RequestBody User u,@PathVariable String username)
	{
		return us.updateUser(u,username);
	}
	@DeleteMapping("/deleteUser/{userid}")
	public void deleteUser(@PathVariable int userid) throws UserNotFoundException
	{
		
		 us.deleteUser(userid);
	
	}
}
