package io.javabrains.cardmarket.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.javabrains.cardmarket.models.CardEntity;
import io.javabrains.cardmarket.models.UserEntity;

@Service
public class CardService {
	
	@Autowired
	private CardRepository cardRepository;
	
	public CardEntity getCardByName(String Name) {
		return cardRepository.findByName(Name);
	}
	
	public long getNumber() {
		return cardRepository.count();
	}
	
	public List<CardEntity> getAll(){
		return cardRepository.findAll();
	}
	
	
	
	public void addCard(CardEntity card) {
		cardRepository.save(card);
	}
	
	public void updateCard(CardEntity card) {
		cardRepository.save(card);
	}
	
	public void deleteCard(String id) {
		cardRepository.delete(cardRepository.findById(Integer.parseInt(id)));
	}

	public CardEntity getCardById(String id) {
		return cardRepository.findById(Integer.parseInt(id));
	}
	

}