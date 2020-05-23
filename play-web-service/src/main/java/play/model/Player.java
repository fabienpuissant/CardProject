package play.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Player {
	private String id;
	private List<CardPublic> cardList;
	private String selectedCardId = "0";
	private int score = 0;
	private CardPublic selectedCard;
	
	public Player() {
		
	}
	
	public Player(String id) throws JsonParseException, JsonMappingException, IOException {
		this.id = id;
		//Get random cards from the CardService and store it in the cardList
		this.pickRandom(this.id);
	}


	public void setPlayerId(String Id) {
		this.id = Id;
	}
	
	public String getPlayerId() {
		return this.id;
	}
	
	public void setSelectedCard(String Id) {
		this.selectedCardId = Id;
		this.setSelectedCard(this.cardList.get(Integer.parseInt(Id)));
	}
	
	public CardPublic getSelectedCard() {
		return this.selectedCard;
	}
	
	
	public List<CardPublic> getCardList(){
		return this.cardList;
	}
	
	public void addCard(CardPublic card){
		this.cardList.add(card);
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void addScore(int point) {
		this.score += point;
	}

	public void removeCard() {
		for (CardPublic card: this.getCardList()) {
			if (card.getId().toString().contentEquals(this.selectedCardId)) {
				this.getCardList().remove(card);
			}
		}
		
	}
	
	
	private void pickRandom(String id) throws JsonParseException, JsonMappingException, IOException {
		URL url = new URL("http://localhost:8082/CardWebService/pickCards/" + id);
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(httpURLConnection.getInputStream()));
        String inputLine;
        StringBuffer response1 = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
        	response1.append(inputLine);
		} in .close();
		
	    //TODO Conversion en objets Event 
		ObjectMapper mapper = new ObjectMapper();

        CardPublic[] cards= mapper.readValue(response1.toString(), CardPublic[].class);
        int i;
		for(i = 0; i< cards.length; i++) {
			this.addCard(cards[i]);
		}

		
	}

	public void setSelectedCard(CardPublic selectedCard) {
		this.selectedCard = selectedCard;
	}

	public String getSelectedCardId() {
		return selectedCardId;
	}

	public void setSelectedCardId(String selectedCardId) {
		this.selectedCardId = selectedCardId;
	}

	
	
	
}
