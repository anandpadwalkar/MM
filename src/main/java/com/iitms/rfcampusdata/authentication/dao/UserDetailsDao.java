package com.iitms.rfcampusdata.authentication.dao;

import com.iitms.rfcampusdata.authentication.entity.User;

public interface UserDetailsDao {
	public User loadUserByUsername(String username);
}
