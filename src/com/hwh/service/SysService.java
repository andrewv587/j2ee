package com.hwh.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hwh.dao.Role_permissionDAO;
import com.hwh.dao.UserDAO;
import com.hwh.dao.User_roleDAO;
import com.hwh.model.Permission;
import com.hwh.model.Role;
import com.hwh.model.Role_permission;
import com.hwh.model.User;
import com.hwh.model.User_role;

@Service
@Transactional
public class SysService {

	private User_roleDAO user_roleDAO;
	private Role_permissionDAO role_permissionDAO;
	private UserDAO userDAO;

	public User_roleDAO getUer_roleDAO() {
		return user_roleDAO;
	}

	@Autowired
	public void setUser_roleDAO(User_roleDAO uer_roleDAO) {
		this.user_roleDAO = uer_roleDAO;
	}

	public User getUser(String username) {
		return this.userDAO.findUserByName(username);
	}

	public void saveUser(User user) {
		this.userDAO.saveEntity(user);
	}

	public void saveOrUpdateUser(User user) {
		this.userDAO.saveOrUpdate(user);
	}

	public void updateUser(User user) {
		this.userDAO.saveOrUpdate(user);
	}
	
	public void deleteUser(User user) {
		this.userDAO.deleteEntity(user);
	}
	
	public User getUserById(int id){
		return this.userDAO.getEntity(id);
	}

	public List<User> findAllUser() {
		return this.userDAO.findAllEntity();
	}
	
	public List<User> paginationUser(int first, int pageSize){
		return this.userDAO.paginationEntity(first, pageSize);
	}
	
	public int findUserNum(){
		return this.userDAO.findEntityNum();
	}
	
	public List<String> getPermissions(String username) {
		List<User_role> user_roles = this.user_roleDAO.find(username);
		List<String> permissions = new ArrayList<String>();
		for (User_role tmpUR : user_roles) {
			Role role = tmpUR.getRole();
			List<Role_permission> role_permissions = this.role_permissionDAO
					.find(role);
			for (Role_permission tmpRP : role_permissions) {
				Permission pm = tmpRP.getPermission();
				permissions.add(pm.getUrl());
			}
		}
		return permissions;
	}

	public Role_permissionDAO getRole_permissionDAO() {
		return role_permissionDAO;
	}

	@Autowired
	public void setRole_permissionDAO(Role_permissionDAO role_permissionDAO) {
		this.role_permissionDAO = role_permissionDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
}
