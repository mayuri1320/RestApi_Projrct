package com.spring.RestApi.service;

import java.util.List;

import com.spring.RestApi.exception.UserNotFoundException;
import com.spring.RestApi.model.User;

public interface UserService {

	User saveUser(User u) throws UserNotFoundException;

	List<User> getUsers();

	User updateUser(User u, String username);

	User getUser(String username) throws UserNotFoundException;

	void deleteUser(int userid) throws UserNotFoundException;



}
