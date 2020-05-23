package play.restcontroller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import play.util.Tools;
import play.model.Player;
import play.model.PvpGame;
import play.service.PlayService;

@CrossOrigin(origins = "", allowedHeaders = "")
@RestController
public class PlayRestController {
	private ArrayList<PvpGame> listPvP =new ArrayList<PvpGame>();
	
	@Autowired
	private PlayService playService;
	
	public PlayRestController() {
	}
	
	@GetMapping("PlayService/New/{roomId}/{userlist}")
	public void newPvpGame(@PathVariable String roomId, @PathVariable String userlist) throws IOException {
		PvpGame pvpGame =new PvpGame();
		pvpGame.setRoom(roomId);
		StringTokenizer ST = new StringTokenizer(userlist, "_");
		String A = "" + ST.nextToken();
		String B = "" + ST.nextToken(); 
		Player playerA = new Player(A);
		Player playerB = new Player(B);
		pvpGame.addPlayer(playerA);
		pvpGame.addPlayer(playerB);
		listPvP.add(pvpGame);
	}
	
	@GetMapping("PlayService/chooseCard/{roomId}/{userId}")
	public List<String> chooseCard(@PathVariable String roomId, @PathVariable String userId) throws IOException {
		List<String> userCards = playService.getUserCards(this.listPvP, roomId, userId);
		return userCards;
	}
	
	@GetMapping("PlayService/playCard/{roomId}/{userId}/{cardId}")
	public String playCard(@PathVariable String roomId, @PathVariable String userId, @PathVariable String cardId) {
		playService.playRound(this.listPvP, roomId,userId,cardId);
		return null;
	}
	

}
