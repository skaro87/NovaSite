package se.skaro.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import se.skaro.resources.BannerLoader;

@RestController
public class ResourceController {
	
	@Autowired
	private BannerLoader bannerLoader;
	
	@RequestMapping("/banner")
	 public Map<String,Object> banner() {
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("image", "/img/banner/"+bannerLoader.getRandomBanner());
	    return model;
	  }
	
	 @RequestMapping("/user")
	  public Principal user(Principal user) {
	    return user;
	  }
	 
}
