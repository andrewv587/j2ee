package com.hwh.dao;

import com.hwh.model.User;

public interface UserDAO extends BasicDAO<User>{
	User findUserByName(String name);
}
