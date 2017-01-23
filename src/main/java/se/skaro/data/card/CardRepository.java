package se.skaro.data.card;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository  extends JpaRepository<Card, Long> {
	
	@Cacheable(value = "cards")
	List<Card> findAll();
	
	@Cacheable(value = "cards")
	Card findById(long id);

}
