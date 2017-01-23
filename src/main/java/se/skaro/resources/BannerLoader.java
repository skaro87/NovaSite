package se.skaro.resources;

import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class BannerLoader {
	
	private String[] bannerNames = new String[]{
			"assaultmech.png",
			"banishment.png",
			"elfninja.png",
			"fairyrouge.png",
			"fieldmedic.png",
			"lightningangel.png"
	};
	
	private Random rand;
	
	@PostConstruct
	public void postConstruct(){
		rand = new Random();
	}
	
	public String getRandomBanner(){
		return bannerNames[rand.nextInt(bannerNames.length)];
	}

}
