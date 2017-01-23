package se.skaro.data.deck;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DeckRepository extends JpaRepository<Deck, Long>{

	List<Deck> findAll();

	Deck findById(long id);

}
