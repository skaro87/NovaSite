package se.skaro.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import se.skaro.data.card.Card;
import se.skaro.data.card.CardRepository;

@RestController
public class CardController {
	
	@Autowired
	private CardRepository cardRepository;

	@RequestMapping("/cards")
	public @ResponseBody Map<String, List<Card>> getArticles() {
		return Collections.singletonMap("data", cardRepository.findAll());

	}
	
	@RequestMapping("/cards/{id}")
	public @ResponseBody Map<String, Card> getArticleById(@PathVariable ("id") long id) {
		return Collections.singletonMap("data", cardRepository.findById(id));

	}

}
