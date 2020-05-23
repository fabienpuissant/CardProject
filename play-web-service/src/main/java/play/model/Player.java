package play.model;

import java.util.List;

public class Player {
	private String id;
	private List<String> cardList;
	private String selectedCardId = "0";
	private int score = 0;
	
	public Player() {
		
	}
	
	public Player(String id) {
		this.id = id;
		this.pickRandom(4);
	}
	
	public void setPlayerId(String Id) {
		this.id = Id;
	}
	
	public String getPlayerId() {
		return this.id;
	}
	
	public void setSelectedCard(String Id) {
		this.selectedCardId = Id;
	}
	
	public String getSelectedCard() {
		return this.selectedCardId;
	}
	
	public void pickRandom(int nbCard) {
		this.cardList.add("id");
	}
	
	public List<String> getCardList(){
		return this.cardList;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void addScore(int point) {
		this.score += point;
	}

	public void removeCard() {
		for (String card: this.getCardList()) {
			if (card == this.selectedCardId) {
				this.getCardList().remove(card);
			}
		}
		
	}
}
