package com.hwh.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.hwh.dao.BookDAO;
import com.hwh.model.Bookinfo;

@Component
public class BookDAOImpl implements BookDAO {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public List<Bookinfo> bookQuery() {
		return (List<Bookinfo>) this.hibernateTemplate.find("from com.hwh.model.Bookinfo");
	}

}
