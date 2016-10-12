package com.hwh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hwh.dao.UserDAO;
import com.hwh.model.User;

//@Component
@Service
public class UserService {
	
	private UserDAO userDAO;
	
	@Transactional//Ä¬ÈÏÎªRequired(propagation=Propagation.MANDATORY,readOnly,rollBackFor,timeoutµÈ)
	public void add(User user){
		this.userDAO.save(user);
	}

	public void destory(){
		System.out.println("destroy");
	}
	
	public UserDAO getUserDAO() {
		return userDAO;
	}
	
	
	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	
}
