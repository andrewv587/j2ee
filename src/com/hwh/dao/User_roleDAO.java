package com.hwh.dao;

import java.util.List;

import com.hwh.model.User_role;

public interface User_roleDAO {
	List<User_role> find(String username);
}
