package se.skaro.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import se.skaro.data.deck.Deck;
import se.skaro.data.deck.DeckDTO;
import se.skaro.data.deck.DeckRepository;
import se.skaro.data.deck.DeckValuePairDTO;
import se.skaro.data.likes.DeckLike;
import se.skaro.data.likes.LikesRepository;

@RestController
public class DeckController {

	@Autowired
	private DeckRepository deckRepository;
	
	@Autowired
	private LikesRepository likesRepository;

	@RequestMapping("/decks")
	public @ResponseBody Map<String, List<DeckDTO>> getDecks() {
		List<DeckDTO> decks = new ArrayList<DeckDTO>();
		deckRepository.findAll().forEach(d -> {
			decks.add(new DeckDTO(d, 0));
		});
		return Collections.singletonMap("data", decks);

	}

	@RequestMapping("/decks/{id}")
	public @ResponseBody Map<String, DeckDTO> getDeckById(@PathVariable("id") long id) {
		Deck deck = deckRepository.findById(id);		
		deck.addView();
		deckRepository.save(deck);
		return Collections.singletonMap("data", new DeckDTO(deck, likesRepository.findByDeckid(id).size()));

	}

	@RequestMapping(value = "/decks", method = RequestMethod.POST)
	public @ResponseBody Map<String, DeckDTO> createDeck(@RequestBody DeckDTO deckDTO) {
		Deck deckToSave = new Deck(deckDTO.getOwner(), deckDTO.getName(), deckDTO.getDescription());

		for (DeckValuePairDTO d : deckDTO.getCardsInDeck()) {
			deckToSave.getCardsInDeck().put(d.getId(), d.getQuantity());
		}

		deckToSave = deckRepository.save(deckToSave);
		return Collections.singletonMap("data", new DeckDTO(deckToSave, 0));
	}

	@RequestMapping(value = "/decks/{id}", method = RequestMethod.POST)
	public @ResponseBody Map<String, DeckDTO> updateDeck(@PathVariable("id") long id, @RequestBody DeckDTO deckDTO) {
		Deck deckToSave = deckRepository.getOne(id);
		deckToSave.getCardsInDeck().clear();

		for (DeckValuePairDTO d : deckDTO.getCardsInDeck()) {
			deckToSave.getCardsInDeck().put(d.getId(), d.getQuantity());
		}

		deckToSave = deckRepository.save(deckToSave);
		return Collections.singletonMap("data", new DeckDTO(deckToSave, 0));
	}
}
