package com.my.res.resolver;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.my.res.domain.MembersVo;
import com.my.res.service.MembersService;

public class CustomAuthenticationProvider implements AuthenticationProvider{

	private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);
	
	private final MembersService memberService;
	private final BCryptPasswordEncoder passwordEncoder;
	
	public CustomAuthenticationProvider(MembersService memberService, BCryptPasswordEncoder passwordEncoder) {
			this.memberService = memberService;
			this.passwordEncoder = passwordEncoder;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = (String) authentication.getPrincipal();
		String password = (String) authentication.getCredentials();
		
		logger.info("AuthenticationProvider :::::: 1");
		
		MembersVo user = (MembersVo) memberService.loadUserByUsername(username);
		
		if(!user.isEnabled() || !user.isCredentialsNonExpired()) {
			logger.info("isEnabled or isCredentialsNonExpired :::::::: false!");
			throw new AuthenticationCredentialsNotFoundException(username);
		}
		
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) user.getAuthorities();
		
		logger.info("AuthenticationProvider loadUserByUsername :::::: 3");
		
		if(!passwordEncoder.matches(password, user.getPassword())) {
			logger.info("matchPassword :::::::: false!");
			throw new BadCredentialsException(username);
		}
		
		logger.info("matchPassword :::::::: true!");
		
		return new UsernamePasswordAuthenticationToken(username, password, authorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

	
}
