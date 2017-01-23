package se.skaro.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import se.skaro.config.SecurityConfiguration;
import se.skaro.data.user.RoleRepository;
import se.skaro.data.user.User;
import se.skaro.data.user.UserDTO;
import se.skaro.data.user.UserRepository;

@RestController
public class UserController {
	
	
	@Autowired
	private SecurityConfiguration securityConfig;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired RoleRepository RoleRepository;
	
	@RequestMapping(value = "/registeruser", method = RequestMethod.POST)
	public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO){
		if (userRepository.findByUsername(userDTO.getUsername()) != null){	
			System.out.println("HERE"); 
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
		else {
		
		PasswordEncoder encoder = securityConfig.passwordencoder();		
		String encodedPassword = encoder.encode(userDTO.getPassword());		
		User user = new User(userDTO.getUsername(), encodedPassword, userDTO.getEmail());
		userRepository.save(user);
		return new ResponseEntity<>(HttpStatus.CREATED);
		}
		
		
		
	}

}
