package io.javabrains.cardmarket.controllers;


import java.util.List;

import org.springframework.data.repository.CrudRepository;


import io.javabrains.cardmarket.models.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer>{
	
	public UserEntity findOneByName(String Name);
	
	public List<UserEntity> findAll();

	public UserEntity findById(int id);

}
