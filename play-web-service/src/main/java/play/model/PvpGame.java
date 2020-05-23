package play.model;

import java.util.List;
import java.util.ListIterator;

public class PvpGame {
	private String roomid;
	private List<Player> playerList; //list d'id de carte possédé par le joueur
	public boolean round = false;

	public PvpGame() {
	}
	
	public void setRoom(String roomId) {
		this.roomid = roomId;
	}
	
	public String getRoom() {
		return this.roomid;
	}
	
	public void addPlayer(Player player) {
		this.playerList.add(player);
	}
	
	public Player getPlayerById(String id) {
		for (Player player: this.getPlayerList()) {
	    	if (player.getPlayerId() == id) {
	    		return player;
	    	}
	    }
		return null;
	}
	
	public List<Player> getPlayerList(){
		return this.playerList;
	}
}

