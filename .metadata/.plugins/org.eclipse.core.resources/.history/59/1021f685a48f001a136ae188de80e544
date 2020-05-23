package io.javabrains.cardmarket.controllers;


import java.util.List;

import org.springframework.data.repository.CrudRepository;


import io.javabrains.cardmarket.models.CardEntity;
import io.javabrains.cardmarket.models.UserEntity;

public interface CardRepository extends CrudRepository<CardEntity, Integer>{
	
	public CardEntity findByName(String Name);

	public CardEntity findById(int id);
	
	public List<CardEntity> findAll();
	
	public long count();

}