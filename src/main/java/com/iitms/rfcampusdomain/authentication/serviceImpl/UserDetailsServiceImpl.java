package com.iitms.rfcampusdomain.authentication.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.iitms.rfcampusdata.authentication.dao.UserDetailsDao;
import com.iitms.rfcampusdata.authentication.entity.Roles;
import com.iitms.rfcampusdata.authentication.entity.SessionUser;
import com.iitms.rfcampusdata.authentication.entity.User;
import com.iitms.rfcampusdata.authentication.entity.UserRoles;


@Component(value = "userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService{

	private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
	
	@Autowired
	private UserDetailsDao userDetailsDao;
	
	
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("loadUserByUsername : " + username);
		User user = userDetailsDao.loadUserByUsername(username);
	SessionUser sessionUser  = new SessionUser();
	sessionUser.setUsername(user.getUsername());
	sessionUser.setPassword(user.getPassword());
	sessionUser.setEnabled(user.isEnabled());
	List<Roles> roles = new ArrayList<Roles>();
	logger.info("Size : "+  user.getUserRoles().size());
	for(UserRoles userRoles : user.getUserRoles()){
		roles.add(userRoles.getRole());
	}
	sessionUser.setRoles(roles);
	
	logger.info("Session : " + sessionUser);
	return sessionUser;
	}

}
