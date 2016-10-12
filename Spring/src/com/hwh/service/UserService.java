package com.hwh.service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.hwh.dao.UserDAO;
import com.hwh.model.User;

public class UserService {
	private UserDAO userDAO;
	
/*	public UserService(UserDAO userDAO) {
		super();
		this.userDAO = userDAO;
	}*/
	@PostConstruct
	public void init(){
		System.out.println("init();");
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}
	
	//@Autowired
	@Resource
	public void setUserDAO(/*@Qualifier("userDAO1")*/ UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public void add(User user){
		this.userDAO.save(user);
	}
	
	public void destory(){
		System.out.println("destroy");
	}
	
	
}
