package io.javabrains.cardmarket.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.javabrains.cardmarket.models.UserEntity;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<UserEntity> getAll(){
		return userRepository.findAll();
	}
	
	public UserEntity getUserByName(String Name) {
		return userRepository.findOneByName(Name);
	}
	
	public UserEntity getUserById(String id) {
		return userRepository.findById(Integer.parseInt(id));
	}
	
	public boolean addUser(UserEntity user) {
		if(userRepository.findOneByName(user.getName()) == null) {
			userRepository.save(user);
			return true;
		}
		return false;
		
	}
	
	public void updateUser(UserEntity user) {
		userRepository.save(user);
	}
	
	public void deleteUser(String id) {
		userRepository.delete(userRepository.findById(Integer.parseInt(id)));
	}
	

}
