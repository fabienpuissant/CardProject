package io.javabrains.cardmarket.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.cardmarket.models.CardEntity;
import io.javabrains.cardmarket.models.CardFactory;
import io.javabrains.cardmarket.models.UserEntity;
import io.javabrains.cardmarket.utils.Tools;

@RestController
public class MarketRestController {
	
	private CardFactory cardFactory = new CardFactory();
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CardService cardService;
	
	/**
	 * Get all cards that user does not have
	 * @param id
	 * @return String all the card that user can buy
	 * @throws IOException
	 */
	@GetMapping("MarketService/user/BuyCards/{id}")
	public String getBuyCards(@PathVariable String id) throws IOException {
		Set<CardEntity> userCards = userService.getUserById(id).getCards();
		List<CardEntity> allCards = cardService.getAll();
		String buyCards = "";
		for(CardEntity card: allCards) {
			if(!userCards.contains(card)) {
				buyCards += String.valueOf(card.getId()) + "/";
			}
		}
		return this.CardStringConversion(buyCards);
	}
	
	/**
	 * Craft a card to the user 
	 * @param name
	 * @return
	 */
	@GetMapping("MarketService/craft/{name}")
	public String craftCard(@PathVariable String name) {
		UserEntity user = userService.getUserByName(name);
		if(user.getMoney() < 100){
			return "";
		}
		else {
			CardEntity card = cardFactory.createCard();
			user.addCard(card);
			cardService.addCard(card);
			if(user.getMoney() < 250) {
				return "";
			}
			user.setMoney(user.getMoney() - 250);
			userService.updateUser(user);
			return Tools.toJsonString(card);
			
		}
	}
	
	
	/**
	 * Sell the card of the user
	 * @param name
	 * @param imgId
	 * @return boolean
	 */
	@GetMapping("MarketService/Sell/{name}/{imgId}")
	public boolean sellCard(@PathVariable String name, @PathVariable String imgId) {
		UserEntity user = userService.getUserByName(name);
		CardEntity card = cardService.getCardById(imgId);
		boolean bool = user.removeCard(card);
		user.setMoney(user.getMoney() + card.getPrice());
		userService.updateUser(user);
		return bool;
	}
	
	
	/**
	 * Buy the imgId card to the user corresponding to the name given
	 * @param name
	 * @param imgId
	 * @return
	 */
	@GetMapping("MarketService/Buy/{name}/{imgId}")
	public boolean buyCard(@PathVariable String name, @PathVariable String imgId) {
		UserEntity user = userService.getUserByName(name);
		CardEntity card = cardService.getCardById(imgId);
		if(user.getMoney() < card.getPrice()) {
			return false;
		}
		user.addCard(card);
		user.setMoney(user.getMoney() - card.getPrice());
		userService.updateUser(user);
		return true;
		
		
	}
	
	/**
	 * Erase the last character of the string
	 * @param String
	 * @return String
	 */
	private String CardStringConversion(String str) {
	        return str = str.substring(0, str.length() - 1);
	}
}
