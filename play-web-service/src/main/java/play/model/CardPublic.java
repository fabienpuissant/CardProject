package play.model;

public class CardPublic {

	private Integer id;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	private String userId;
	
	private String name;
	

	private String imgUrl;
	

	private String description;
	

	private Integer attack;
	
	
	private Integer defence;
	
	
	private Integer price;
	

	
	public CardPublic(String Name, String imgUrl, String Description, Integer Attack, Integer Defence) {
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
