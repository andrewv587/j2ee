package com.hwh.dao;

import java.util.List;


public interface BasicDAO<T> {
	//写操作
	void saveEntity(T t);
	void saveOrUpdate(T t);
	void update(T t);
	void deleteEntity(T t);
	/*void batchEntityByHQL(String hql,Object...objects);*/
	
	//读操作
	T getEntity(int id);
	T loadEntity(int id);
	List<T> findByNamedParam(String queryString , String[] paramName , Object[] value);
	List<T> findAllEntity();
	int findEntityNum();
	List<T> paginationEntity(int first, int pageSize);
}
