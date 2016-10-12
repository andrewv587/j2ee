package com.hwh.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.hwh.dao.UserDAO;
import com.hwh.model.User;

@Repository
public class UseDAOImp extends AbstractBasicDAOImpl<User> implements UserDAO{

	@SuppressWarnings("unchecked")
	@Override
	public User findUserByName(String name) {
		System.out.println("OK");
		String sql="from User where username=:name" ;
		List<User> users=(List<User>) this.getHibernateTemplate().findByNamedParam(sql, "name" , name);
		System.out.println("OK1");
		return users.get(0);
	}
	

}
