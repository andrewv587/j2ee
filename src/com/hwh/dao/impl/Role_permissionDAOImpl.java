package com.hwh.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hwh.dao.Role_permissionDAO;
import com.hwh.model.Role;
import com.hwh.model.Role_permission;


@Repository
public class Role_permissionDAOImpl implements Role_permissionDAO{
	
	
	private HibernateTemplate hibernateTemplate;

	@Autowired
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public List<Role_permission> find(Role role) {
		String query = "from Role_permission t where t.role.rolename=?";
		@SuppressWarnings("unchecked")
		List<Role_permission> list = (List<Role_permission>) this.hibernateTemplate.find(query,
				role.getRolename());
		return list;
	}
	
}
