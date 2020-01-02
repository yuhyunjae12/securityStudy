package com.my.res.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.my.res.dao.MembersDao;
import com.my.res.domain.MembersVo;

@Service
public class MembersService implements UserDetailsService{

    private static final Logger log = LoggerFactory.getLogger(MembersService.class);

	private final MembersDao membersDao;
	
	public MembersService (MembersDao membersDao) {
		this.membersDao = membersDao;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		log.info("loadUserByUsername.....");
		
		MembersVo user = membersDao.getUserById(username);
		
		if(user==null) {
			log.info("no user :::::::: AuthenticationProvider");
			throw new InternalAuthenticationServiceException(username);
		}

		return user;
	}

	public List<MembersVo> getMembersList(){
		return membersDao.getMembersList();
	}
	
}
