package io.javabrains.cardmarket.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "card_entity")
public class CardEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column
	private String name;
	
	@Column
	private String imgUrl;
	
	@Column
	private String description;
	
	@Column
	private Integer attack;
	
	@Column
	private Integer defence;
	
	@Column
	private Integer price;
	
	public CardEntity() {
		
	}
	
	public CardEntity(String Name, String imgUrl, String Description, Integer Attack, Integer Defence) {
		this.name = Name;
		this.imgUrl = imgUrl;
		this.description = Description;
		this.attack = Attack;
		this.defence = Defence;
		this.price = this.attack + this.defence;
		
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

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getAttack() {
		return attack;
	}

	public void setAttack(Integer attack) {
		this.attack = attack;
	}

	public Integer getDefence() {
		return defence;
	}

	public void setDefence(Integer defence) {
		this.defence = defence;
	}
	
	public String toString() {
		return "Card Name : " + this.name + "\n " + 
				"Card Description : " + this.description + "\n \n";
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

}
