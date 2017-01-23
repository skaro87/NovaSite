package se.skaro.data.likes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LikesRepository extends JpaRepository<DeckLike, Long>{
	
	List<DeckLike> findByDeckid(long deckId);

}
