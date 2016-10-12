package com.hwh.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.hwh.dao.UserDAO;
import com.hwh.model.User;

@Repository
public class UserDAOimpl implements UserDAO{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void save(User user) {
		entityManager.persist(user);
	}

}
