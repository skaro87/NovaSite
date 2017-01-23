package se.skaro.data.likes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "deck_like")
public class DeckLike {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private long deckid;
	
	@Column(name="user_name", length=25)
	private String userName;

	public long getDeckid() {
		return deckid;
	}

	public String getUserid() {
		return userName;
	}

}
