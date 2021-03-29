package com.tourism.tourism.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.tourism.tourism.models.User;
import com.tourism.tourism.repositories.UserRepository;

@Component
public class CustomUserDetailService implements UserDetailsService{
	
	private final UserRepository userRepository;

	@Autowired
	public CustomUserDetailService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optionalUser =  userRepository.findByUserName(username);
		if (!optionalUser.isPresent()) {
			throw new UsernameNotFoundException("Usuario não encontrado");			
		}
		User user = optionalUser.get();
		List<GrantedAuthority> authoritiesEmployee = AuthorityUtils.createAuthorityList("ROLE_EMPLOYEE");
		List<GrantedAuthority> authoritiesTourist = AuthorityUtils.createAuthorityList("ROLE_ANONYMOUS", "ROLE_TOURIST");
		List<GrantedAuthority> authoritiesTouristAnonymous = AuthorityUtils.createAuthorityList("ROLE_ANONYMOUS");
		
		List<GrantedAuthority> authoritiesCurrent;
		
		switch (user.getRole().toString()) {
		case "EMPLOYEE":
			authoritiesCurrent = authoritiesEmployee;
			break;
		case "TOURIST":
			authoritiesCurrent = authoritiesTourist;
			break;
		default:
			authoritiesCurrent = authoritiesTouristAnonymous;
			break;
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), authoritiesCurrent);
	}

}
