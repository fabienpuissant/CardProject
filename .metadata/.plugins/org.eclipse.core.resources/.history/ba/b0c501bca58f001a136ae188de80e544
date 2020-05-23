package io.javabrains.cardmarket.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import io.javabrains.cardmarket.models.CardEntity;
import io.javabrains.cardmarket.models.CardFactory;
import io.javabrains.cardmarket.utils.Tools;


@RestController
public class CardRestController {
	
	private CardFactory cardFactory = new CardFactory();
	
	
	private CardService cardService;
	
	public CardRestController(CardService cardService) {
		this.cardService = cardService;
		List<CardEntity> cardlist = this.generateCard();
		for (int i = 0; i < cardlist.size(); i++) {
			CardEntity card = cardlist.get(i);
			cardService.addCard(card);
		}
	}
	
	/**
	 * Get all the cards of the user
	 * @param Userid
	 * @return String
	 * @throws IOException
	 */
	@GetMapping("CardService/card/{Userid}")
	public String getcard(@PathVariable String Userid) throws IOException {
		String userCards = this.getUserCards(Userid); 
		return userCards;

	}
	
	/**
	 * Get number of cards in the database
	 * @return long
	 */
	@GetMapping("CardService/card/number")
	public long getNumber() {
		return cardService.getNumber();
	}
	
	/**
	 * Get the card with corresponding id
	 * @param id
	 * @return String Json of the card
	 */
	@GetMapping("CardService/{id}")
	public String getCardFeatures(@PathVariable String id) {
		CardEntity card = cardService.getCardById(id);
		return Tools.toJsonString(card);
	}
	
	
	/**
	 * Add a card 
	 * @param card
	 */
	@PostMapping(value="CardService/addCard", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void addCard(@RequestBody CardEntity card) {
		cardService.addCard(card);
	}
	
	/**
	 * Get the corresponding id card of the user
	 * @param id
	 * @return String 
	 * @throws IOException
	 */
	private String getUserCards(String id) throws IOException {
		URL obj = new URL("http://localhost:8080/UserService/user/cards/"+id);
        HttpURLConnection httpURLConnection = (HttpURLConnection) obj.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(httpURLConnection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                 while ((inputLine = in.readLine()) != null) {
                   response.append(inputLine);
                 } in .close();
        return response.toString();
	}
	
	/**
	 * Generation of initial cards
	 * @return List<CardEntity>
	 */
	private List<CardEntity> generateCard(){
		List<CardEntity> cardlist = new ArrayList<CardEntity>();
		for (int i = 0; i < 20; i++) {
			cardlist.add(this.cardFactory.createCard());
		}
		
		
		return cardlist;
	}
	


}

