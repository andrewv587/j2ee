package com.hwh.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.hwh.dao.BasicDAO;

public class AbstractBasicDAOImpl<T> implements BasicDAO<T> {

	private HibernateTemplate hibernateTemplate;
	private Class<T> entityClass;

	@SuppressWarnings("unchecked")
	public AbstractBasicDAOImpl() {
		ParameterizedType parameterizedType = (ParameterizedType) this
				.getClass().getGenericSuperclass();
		entityClass = (Class<T>) (parameterizedType.getActualTypeArguments()[0]);
	}

	@Autowired
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Override
	public void saveEntity(T t) {
		this.hibernateTemplate.save(t);
	}

	@Override
	public void saveOrUpdate(T t) {
		this.hibernateTemplate.saveOrUpdate(t);

	}

	@Override
	public void update(T t) {
		this.hibernateTemplate.update(t);

	}

	@Override
	public void deleteEntity(T t) {
		this.hibernateTemplate.delete(t);

	}

	@Override
	public T getEntity(int id) {
		this.hibernateTemplate.get(entityClass, id);
		return null;
	}

	@Override
	public T loadEntity(int id) {
		this.hibernateTemplate.load(entityClass, id);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByNamedParam(String queryString, String[] paramName,
			Object[] value) {
		return (List<T>) this.hibernateTemplate.findByNamedParam(queryString,
				paramName, value);
	}

	@Override
	public List<T> findAllEntity() {
		return this.findByNamedParam("from " + this.entityClass.getName(),
				new String[0], new Object[0]);
	}

	@Override
	public int findEntityNum() {
		/*String hql = "select count(*) from " + this.entityClass.getName();
		int tmp = ((Long) this.getHibernateTemplate().iterate(hql).next())
				.intValue();
		System.out.println("!!!!!--------"+tmp);
		return tmp;*/
		return this.findAllEntity().size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> paginationEntity(int first,final int pageSize) {
		final String className = this.entityClass.getName();
		final int begin = pageSize*(first-1);
		@SuppressWarnings("rawtypes")
		List<T> list = this.getHibernateTemplate().execute(new HibernateCallback() {     
		    public Object doInHibernate(Session session)     
		      throws HibernateException {     
		     Query query = session.createQuery("from "+className);     
		     query.setFirstResult(begin);     
		     query.setMaxResults(pageSize);     
		     List<T> list = query.list();     
		     return list;     
		    }})  ;   
		return list;
	}

}
