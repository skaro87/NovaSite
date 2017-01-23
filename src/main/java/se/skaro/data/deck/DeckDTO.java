package se.skaro.data.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeckDTO {
	
	private int id;
	private String owner;
	private String name;
	private String description;
	private int views;
	private int likes;
	private int aspectOne;
	private int aspectTwo;
	
	private List<DeckValuePairDTO> cardsInDeck;
	
	public DeckDTO(Deck deck, int likes){
		id = deck.getId().intValue();
		owner = deck.getOwner();
		name = deck.getName();
		description = deck.getDescription();
		cardsInDeck = new ArrayList<DeckValuePairDTO>();
		views = deck.getViews();
		this.likes = likes;
		aspectOne = deck.getAspectOne();
		aspectTwo = deck.getAspectTwo();
		
		deck.getCardsInDeck().forEach((k,v)->{
			cardsInDeck.add(new DeckValuePairDTO(k ,v));
		});
		
	}
	
	public DeckDTO(){}
	
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<DeckValuePairDTO> getCardsInDeck() {
		return cardsInDeck;
	}

	public void setCardsInDeck(List<DeckValuePairDTO> cardsIndeck) {
		this.cardsInDeck = cardsIndeck;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getAspectOne() {
		return aspectOne;
	}

	public void setAspectOne(int aspectOne) {
		this.aspectOne = aspectOne;
	}

	public int getAspectTwo() {
		return aspectTwo;
	}

	public void setAspectTwo(int aspectTwo) {
		this.aspectTwo = aspectTwo;
	}

	
	
	
	
	
	

}
