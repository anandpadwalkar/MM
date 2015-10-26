package com.iitms.rfcampusdata.authentication.daoImpl;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iitms.rfcampusdata.authentication.dao.UserDetailsDao;
import com.iitms.rfcampusdata.authentication.entity.User;


@Repository
public class UserDetailsDaoImpl implements UserDetailsDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User loadUserByUsername(String username) {
		Object o = this.sessionFactory.getCurrentSession()
		.createCriteria(User.class)
		.add(Restrictions.eq("username", username))
		.uniqueResult();
		return (User) o;
	}
	
	
}
