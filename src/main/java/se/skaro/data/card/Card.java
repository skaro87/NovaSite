package se.skaro.data.card;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="card")
public class Card {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "text")
	private String text;
	
	@Column(name = "aspect")
	private int aspect;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "subtype")
	private String subtype;
	
	@Column(name = "cost")
	private int cost;
	
	@Column(name = "attack")
	private int attack;
	
	@Column(name = "health")
	private int health;
	
	@Column(name = "rarity")
	private int rarity;

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public String getText() {
		return text;
	}

	public int getAspect() {
		return aspect;
	}

	public String getType() {
		return type;
	}

	public String getSubtype() {
		return subtype;
	}

	public int getCost() {
		return cost;
	}

	public int getAttack() {
		return attack;
	}

	public int getHealth() {
		return health;
	}
	
	public int getRarity() {
		return rarity;
	}
	
}
