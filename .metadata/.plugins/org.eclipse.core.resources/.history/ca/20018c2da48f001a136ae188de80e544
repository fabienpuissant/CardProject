package io.javabrains.cardmarket.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.cardmarket.models.CardEntity;
import io.javabrains.cardmarket.models.CardFactory;
import io.javabrains.cardmarket.models.UserEntity;
import io.javabrains.cardmarket.utils.Tools;

@RestController
public class UserRestController {
	
	private CardFactory cardFactory = new CardFactory();
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CardService cardService;
	
	/**
	 * Get user information from name
	 * @param name
	 * @return UserEntity
	 */
	@GetMapping("UserService/user/{name}")
	public UserEntity getUser(@PathVariable String name) {
		return userService.getUserByName(name);
	}
	
	/**
	 * Get the money of the user
	 * @param name
	 * @return String the money of the user
	 */
	@GetMapping("UserService/user/money/{name}")
	public String getMoney(@PathVariable String name) {
		return userService.getUserByName(name).getMoney().toString();
	}
	
	/**
	 * Return information of user if name and password match, otherwise return void string
	 * @param name
	 * @param pswd
	 * @return String 
	 */
	@GetMapping("UserService/user/{name}/{pswd}")
	public String checkUser(@PathVariable String name, @PathVariable String pswd){
		UserEntity user = userService.getUserByName(name);
		if(user == null) {
			return "";
		}
		else if(!user.getPassword().contentEquals(pswd)) {
			return "";
		}
		return Tools.toJsonString(user);
	}
	
	/**
	 * Get all cards that user owns
	 * @param id of the user
	 * @return String the cards of the user 
	 */
	@GetMapping("UserService/user/cards/{id}")
	public String getCards(@PathVariable String id) {
		Set<CardEntity> userCards = userService.getUserById(id).getCards();
		String cardsString = "";
		for(CardEntity card: userCards) {
			cardsString += String.valueOf(card.getId()) + "/";
		}
		return this.CardStringConversion(cardsString);
		
	}
	
	
	/**
	 * Add user in the database
	 * @param user
	 * @return boolean true if no errors
	 * @throws IOException
	 */
	@PostMapping(value="UserService/addUser", consumes=MediaType.APPLICATION_JSON_VALUE)
	public boolean addUser(@RequestBody UserEntity user) throws IOException {
		boolean bool = userService.addUser(user);
		if(!bool) {
			return false;
		}
		for (int i = 0; i < 5; i++) {
			CardEntity card = cardFactory.createCard();
			cardService.addCard(card);
			user.addCard(card);
		}
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
