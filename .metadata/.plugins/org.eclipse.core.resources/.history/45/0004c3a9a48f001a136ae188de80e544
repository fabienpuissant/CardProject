package io.javabrains.cardmarket.models;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class CardFactory {
	
	private String[] names;
	
	private String champions = "Aatrox/Ahri/Akali/Alistar/Amumu/Anivia/Annie/Aphelios/Ashe/Aurelion Sol/Azir/Bard/Blitzcrank/Brand/Braum/Caitlyn/Camille/Cassiopea/ChoGath/Corki/Darius/Diana/Draven/DrMundo/Ekko/Elise/Evelynn/Ezreal/Fiddlestick/Fiora/Fizz/Galio/Gangplank/Garen/Gnar/Gragas/Graves/Hecarim/Heimerdinger/Illaoi/Irelia/Ivern/Janna/JarvanIV/Jax/Jayce/Jhin/Jinx/Kaisa/Kalista/Karma/Karthus/Kassadin/Katarina/Kayle/Kayne/Kennen/Khazix/Kindred/Kled/KogMaw/Leblanc/LeeSin/Leona/Lissandra/Lucian/Lulu/Lux/Malphite/Malzahar/Maokai/Master Yi/Miss Fortune/Morderkaiser/Morgana/Nami/Nasus/Nautilus/Neeko/Nidalee/Nocturne/Nunu/Olaf/Orianna/Ornn/Pantheon/Poppy/Pyke/Qiyana/Quinn/Rakan/Rammus/Reksai/Renekton/Rengar/Riven/Rumble/Ryze/Sejuani/Senna/Sett/Shaco/Shen/Shyvana/Singed/Sion/Sivir/Skarner/Sona/Soraka/Swain/Sylas/Syndra/TahmKench/Taliyah/Talon/Taric/Teemo/Thresh/Tristana/Trundamere/Trundle/Twisted Fate/Twitch/Udyr/Urgot/Varus/Vayne/Veigar/Velkoz/Vi/Viktor/Vladimir/Volibear/Warwick/Wukong/Xayah/Xerath/Xin Zhao/Yasuo/Yorick/Yuumi/Zac/Zed/Ziggs/Zilean/Zoe/Zyra";

	public CardFactory() {
		
		this.names = this.champions.split("/");
	}
	
	public String[] getnames() {
		return names;
	}


	public void setnames(String[] names) {
		this.names = names;
	}

	/**
	 * Create one card
	 * @return CardEntity
	 */
	public CardEntity createCard() {
		Random rand = new Random();
		String name = this.names[rand.nextInt(this.names.length)];
		String imgUrl = "/images/" + name + ".png";
		String description = "";
		int attack = rand.nextInt(100) + 30;
		int defence = rand.nextInt(100) + 30;
		return new CardEntity(name, imgUrl, description, attack, defence);
		
	}
	
	/**
	 * Create all the card for testint phase
	 * @return List<CardEntity>
	 */
	public List<CardEntity> testCards(){
		List<CardEntity> cardlist = new ArrayList<CardEntity>();
		Random rand = new Random();
		for(int i = 0; i < this.names.length; i++) {
			String name = this.names[i];
			String imgUrl = "/images/" + name + ".png";
			String description = "";
			int attack = rand.nextInt(100) + 30;
			int defence = rand.nextInt(100) + 30;
			cardlist.add(new CardEntity(name, imgUrl, description, attack, defence));
		}
		return cardlist;
	}
	
	
}

