package com.hwh.model;

import java.util.ArrayList;
import java.util.List;

public class ActiveUser implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	
	private List<String> menu = new ArrayList<String>();
	private List<String> permissions=new ArrayList<String>();
	
	public void setUser(User user){
		this.username =user.getUsername();
		this.setPassword(user.getPassword());
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public List<String> getMenu() {
		return menu;
	}


	public void setMenu(List<String> menu) {
		this.menu = menu;
	}


	public List<String> getPermissions() {
		return permissions;
	}


	public void setPermissions(List<String> permissions) {
		this.permissions = permissions;
	}
}
