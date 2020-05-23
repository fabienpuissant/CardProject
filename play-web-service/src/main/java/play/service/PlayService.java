package play.service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import play.model.Player;
import play.model.PublicCard;
import play.model.PvpGame;



public class PlayService {
	public List<String> getUserCards(ArrayList<PvpGame> listPvP, String roomId, String userid) {
		for (PvpGame pvpGame: listPvP) {
			if (pvpGame.getRoom() == roomId) {
				pvpGame.getPlayerById(userid).pickRandom(5);
				return pvpGame.getPlayerById(userid).getCardList();
			}
		}
		return null;
	}
	
	public void playRound(ArrayList<PvpGame> listPvP, String roomId, String userid, String cardid) {
		for (PvpGame pvpGame: listPvP) {
			if (pvpGame.getRoom() == roomId) {
				//Room selectionnée, on verifie que les deux joueurs sont prets et  on lance la partie
				if (pvpGame.getPlayerById(userid).getSelectedCard() != "0"){// le joueur ne peux pas changer sa carte selectiionnée
					if (pvpGame.round == true) {
						pvpGame.getPlayerById(userid).setSelectedCard(cardid);
						this.process(pvpGame);
					}
					if (pvpGame.round == false) {
						pvpGame.getPlayerById(userid).setSelectedCard(cardid);
						pvpGame.round = true;
					}
				}
				//
			}
		}
	}
		
	public void process(PvpGame pvpGame) {
		for (Player player: pvpGame.getPlayerList()) {
			ListIterator<Player> it = pvpGame.getPlayerList().listIterator();
			if (it.hasNext()) {
				it.next().getSelectedCard().setVie -= it.previous().getSelectedCard().getAttack;
				if (it.next().getSelectedCard().getVie == 0) {
					it.previous().addScore(1);
					this.endRound(pvpGame);
				}
			}
			if (it.hasPrevious()) {
				it.previous().getSelectedCard().getVie -= it.next().getSelectedCard().getAttack;
				if (it.previous().getSelectedCard().getVie == 0) {
					it.next().addScore(1);
					this.endRound(pvpGame);
				}
			}
		}
	}

	
	public void endRound(PvpGame pvpGame) {
		for (Player player: pvpGame.getPlayerList()) {
			player.removeCard();
		}
	}
			

	

}
