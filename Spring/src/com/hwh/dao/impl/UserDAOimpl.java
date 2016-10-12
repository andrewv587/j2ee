package com.hwh.dao.impl;

import org.springframework.stereotype.Component;

import com.hwh.dao.UserDAO;
import com.hwh.model.User;

@Component
public class UserDAOimpl implements UserDAO{
	
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void save(User user) {
		System.out.println("save "+user.getId()+" "+user.getName());
	}

}
