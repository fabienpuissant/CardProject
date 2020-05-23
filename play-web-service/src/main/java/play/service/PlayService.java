package play.service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import play.model.Player;
import play.model.CardPublic;
import play.model.PvpGame;



public class PlayService {
	
	//Get user Card created when Player object is created. Remove or modify this function ?? as u want
	/*
	public List<String> getUserCards(ArrayList<PvpGame> listPvP, String roomId, String userid) {
		for (PvpGame pvpGame: listPvP) {
			if (pvpGame.getRoom() == roomId) {
				pvpGame.getPlayerById(userid).pickRandom(5);
				return pvpGame.getPlayerById(userid).getCardList();
			}
		}
		return null;
	}*/
	
	public void playRound(ArrayList<PvpGame> listPvP, String roomId, String userid, String cardid) {
		for (PvpGame pvpGame: listPvP) {
			if (pvpGame.getRoom() == roomId) {
				//Room selectionnée, on verifie que les deux joueurs sont prets et  on lance la partie
				if (pvpGame.getPlayerById(userid).getSelectedCardId() != "0"){// le joueur ne peux pas changer sa carte selectiionnée
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
				CardPublic card = it.next().getSelectedCard();
				card.setDefence(card.getDefence() - it.previous().getSelectedCard().getAttack());
				if (card.getDefence() == 0) {
					it.previous().addScore(1);
					this.endRound(pvpGame);
				}
			}
			if (it.hasPrevious()) {
				CardPublic card = it.previous().getSelectedCard();
				card.setDefence(card.getDefence() - it.next().getSelectedCard().getAttack());
				if (card.getDefence() == 0) {
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
