package se.skaro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import se.skaro.data.user.RoleRepository;
import se.skaro.data.user.User;
import se.skaro.data.user.UserRepository;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
	private final UserRepository userRepository;
	private final RoleRepository rolesRepository;

	@Autowired
	public CustomUserDetailsService(UserRepository userRepository, RoleRepository userRolesRepository) {
		this.userRepository = userRepository;
		this.rolesRepository = userRolesRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		
		if (null == user) {
			throw new UsernameNotFoundException("No user present with username: " + username);
		} else {
			List<String> userRoles = rolesRepository.findRoleByUserName(username);
			return new CustomUserDetails(user, userRoles);
		}
	}

}
