package se.skaro.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import se.skaro.data.content.Article;
import se.skaro.data.content.ArticleRepository;

@RestController
public class ArticleController {

	@Autowired
	private ArticleRepository articleRepository;

	@RequestMapping("/articles")
	public @ResponseBody Map<String, List<Article>> getArticles() {
		return Collections.singletonMap("data", articleRepository.findAll());

	}
	
	@RequestMapping("/articles/{id}")
	public @ResponseBody Map<String, Article> getArticleById(@PathVariable ("id") long id) {
		return Collections.singletonMap("data", articleRepository.findById(id));

	}

}
