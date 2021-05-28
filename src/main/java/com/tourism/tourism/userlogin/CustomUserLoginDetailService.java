package com.tourism.tourism.userlogin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserLoginDetailService implements UserDetailsService {
	
	private final UserLoginRepository userLoginRepository;

	@Autowired
	public CustomUserLoginDetailService(UserLoginRepository userLoginRepository) {
		this.userLoginRepository = userLoginRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserLogin> optionalUser =  userLoginRepository.findByUsername(username);
		if (!optionalUser.isPresent()) {
			throw new UsernameNotFoundException("User not found.");
		}
		UserLogin userLogin = optionalUser.get();
		List<GrantedAuthority> authoritiesEmployee = AuthorityUtils.createAuthorityList("ROLE_EMPLOYEE");
		List<GrantedAuthority> authoritiesTourist = AuthorityUtils.createAuthorityList("ROLE_TOURIST");
		List<GrantedAuthority> authoritiesTouristAnonymous = AuthorityUtils.createAuthorityList("ROLE_ANONYMOUS");
		
		List<GrantedAuthority> authoritiesCurrent;
		
		switch (userLogin.getRole().toString()) {
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
		return new org.springframework.security.core.userdetails.User(userLogin.getUsername(), userLogin.getPassword(), authoritiesCurrent);
	}

}
