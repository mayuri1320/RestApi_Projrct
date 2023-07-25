package com.spring.RestApi.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.RestApi.exception.UserNotFoundException;
import com.spring.RestApi.model.User;
import com.spring.RestApi.repository.UserRepository;
import com.spring.RestApi.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository ur;

	@Override
	public User saveUser(User u) throws UserNotFoundException {
		// TODO Auto-generated method stub
	if(ur.existsById(u.getUserid()))
		throw new UserNotFoundException("User Exists");
		return 	ur.save(u);
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return ur.findAll();
	}

	@Override
	public User getUser(String username) throws UserNotFoundException {
		// TODO Auto-generated method stub
		if(ur.findByUsername(username)==null)
			throw new UserNotFoundException("User Not Found");
		return ur.findByUsername(username);
	}

	@Override
	public User updateUser(User u, String username) {
		// TODO Auto-generated method stub
		User user=ur.findByUsername(username);
		if(user!=null)
		{
			user.setUsername(u.getUsername());
			user.setPassword(u.getPassword());
			user.setEmail(u.getEmail());
			user.setAddr(u.getAddr());
			user.setMobileno(u.getMobileno());
			return ur.save(user);
		}
		return null;
	}

	@Override
	public void deleteUser(int userid) throws UserNotFoundException {
		// TODO Auto-generated method stub
		if(ur.findByUserid(userid)==null)
		{
			throw new UserNotFoundException("No Record Found");
		}
		 ur.deleteById(userid);
	}
	
}
