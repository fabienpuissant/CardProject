package io.javabrains.cardmarket.models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "user_entity")
public class UserEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(unique = true)
	private String name;
	
	@Column
	private String surname;
	
	@Column
	private String password;
	
	@Column
	private Integer money;
	
	@OneToMany
	private Set<CardEntity> cards = new HashSet<CardEntity>();
	
	public UserEntity() throws IOException {
		this.money = 5000;

		
	}
	
	public UserEntity(String Name, String Surname, String Password) throws IOException {
		this.name = Name;
		this.surname  = Surname;
		this.password = Password;
		this.money = 5000;
		
	}
	
	public void addCard(CardEntity card) {
		this.cards.add(card);
	}
	
	public boolean removeCard(CardEntity card) {
		for(CardEntity cardUser : this.cards) {
			if(cardUser.getName().contentEquals(card.getName())) {
				this.cards.remove(cardUser);
				return true;
			}
		}
		return false;
		
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	public Set<CardEntity> getCards() {
		return this.cards;
	}

	
	public String toString() {
		return "Name : " + this.name + "\n" + " Surname : " + this.surname + "\n \n"; 
	}
	
	
	
}
