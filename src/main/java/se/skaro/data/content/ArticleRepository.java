package se.skaro.data.content;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long>{
	
	@Cacheable(value = "articles")
	List<Article> findAll();
	
	@Cacheable(value = "articles")
	Article findById(long id);
	
}
