package com.hwh.service;


import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hwh.dao.UserDAO;
import com.hwh.model.User;

@Component
public class UserService {
	private UserDAO userDAO;
	
	//@Transactional//Ĭ��ΪRequired(propagation=Propagation.MANDATORY,readOnly,rollBackFor,timeout��)
	public void add(User user){
		this.userDAO.save(user);
	}

	public void destory(){
		System.out.println("destroy");
	}
	
	public UserDAO getUserDAO() {
		return userDAO;
	}
	
	public void init(){
		System.out.println("init();");
	}
	
	@Resource(name="userDAOimpl")
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	
}
