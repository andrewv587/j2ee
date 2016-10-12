package com.hwh.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hwh.dao.User_roleDAO;
import com.hwh.model.User_role;

@Repository
public class User_roleDAOImpl implements User_roleDAO {

	private HibernateTemplate hibernateTemplate;

	@Autowired
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public List<User_role> find(String username) {
		String query = "from User_role t where t.user.username=?";
		@SuppressWarnings("unchecked")
		List<User_role> list = (List<User_role>) this.hibernateTemplate.find(query,
				username);
		return list;
	}

}
