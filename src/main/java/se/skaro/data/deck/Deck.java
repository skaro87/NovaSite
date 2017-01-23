package se.skaro.data.deck;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

@Entity
@Table (name="deck")
public class Deck {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="owner", nullable = false)
	private String owner;
	
	@Column(name="name", nullable = false)
	private String name;
	
	@Column(name = "description", columnDefinition = "TEXT", nullable = false)
	private String description;
	
	@Column(name = "views", nullable = false)
	private int views;
	
	@Column(name = "aspect_one", nullable = false)
	private int aspectOne;
	
	@Column(name = "aspect_two", nullable = false)
	private int aspectTwo;
	
	
	@ElementCollection
    @MapKeyColumn(name="card_id")
    @Column(name="quantity")
    @CollectionTable(name="deck_quantity", joinColumns=@JoinColumn(name="deck_id"))
    private Map<Integer, Integer> cardsInDeck = new HashMap<Integer, Integer>();
	
	

	public Deck(String owner, String name, String description) {
		this.owner = owner;
		this.name = name;
		this.description = description;
		cardsInDeck = new HashMap<>();
	}
	
	public Deck(){}
	
	
	public void addView() {
		views++;
	}
	

	public Long getId() {
		return id;
	}

	public String getOwner() {
		return owner;
	}
	
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Map<Integer, Integer> getCardsInDeck() {
		return cardsInDeck;
	}

	public int getViews() {
		return views;
	}

	public int getAspectOne() {
		return aspectOne;
	}

	public int getAspectTwo() {
		return aspectTwo;
	}
	
	
	
	
	

	
}
