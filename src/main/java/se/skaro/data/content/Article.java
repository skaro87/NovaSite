package se.skaro.data.content;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table (name="article")
public class Article {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "headline", length = 100, nullable = false)
	private String headline;
	
	@Column(name = "top_image_url", length = 100, nullable = false)
	private String imageUrl;
	
	@Column(name = "text", columnDefinition = "TEXT", nullable = false)
	private String text;
	
	@Column(name = "preview_text", length = 256, nullable = false)
	private String previewText;
	
	@Column(name = "author", length = 100, nullable = false)
	private String author;
	
	@Column(name = "time", length = 100, nullable = false)
	private String time;
	 
	public long getId() {
		return id;
	}
	
	public String getHeadline() {
		return headline;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public String getText() {
		return text;
	}
	
	public String getPreview() {
		return previewText;
	}

	public String getAuthor() {
		return author;
	}

	public String getTime() {
		return time;
	}
	

}
