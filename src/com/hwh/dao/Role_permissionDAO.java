package com.hwh.dao;

import java.util.List;

import com.hwh.model.Role;
import com.hwh.model.Role_permission;

public interface Role_permissionDAO {
	List<Role_permission> find(Role role);
}
