package se.skaro.data.deck;

public class DeckValuePairDTO {
	
	private int cardid;
	private int quantity;
	
	public DeckValuePairDTO(Integer cardid, Integer quantity) {
		this.cardid = cardid;
		this.quantity = quantity;
	}
	public int getId() {
		return cardid;
	}
	public void setId(int cardId) {
		this.cardid = cardId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
