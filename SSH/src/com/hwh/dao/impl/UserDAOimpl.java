package com.hwh.dao.impl;


import javax.annotation.Resource;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.hwh.dao.UserDAO;
import com.hwh.model.User;

@Component
public class UserDAOimpl implements UserDAO{
	
	//private DataSource dataSource;
	//private SessionFactory sessionFactory;
	
	private HibernateTemplate hibernateTemplate;
	
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void save(User user) {
		this.hibernateTemplate.save(user);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

/*	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}*/
	
/*	public DataSource getDataSource() {
		return dataSource;
	}
	
	@Resource
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}*/

}
