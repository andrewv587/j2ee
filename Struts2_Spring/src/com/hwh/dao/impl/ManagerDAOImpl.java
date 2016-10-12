package com.hwh.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hwh.dao.ManagerDAO;
import com.hwh.model.Manager;
import com.hwh.model.Purview;

@Component
public class ManagerDAOImpl implements ManagerDAO {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public Manager getManager(Manager manager) {
		String hql= "from com.hwh.model.Manager mng where mng.name='"+manager.getName()
				+"' and mng.password='"+manager.getPassword()+"'";
		List<Manager> mngs=(List<Manager>) this.hibernateTemplate.find(hql);
		if(mngs.size()==0) 
			return null;
		return mngs.get(0);

	}
	
	@Override
	public Manager getManagerByID(int id) {
		String hql= "from com.hwh.model.Manager mng where mng.id="+id;
		List<Manager> mngs=(List<Manager>) this.hibernateTemplate.find(hql);
		if(mngs.size()==0) 
			return null;
		return mngs.get(0);

	}

	
	@Override
	@Transactional
	public List<Manager> managerQuery() {
		List<Manager> mngs=(List<Manager>) this.hibernateTemplate.find("from com.hwh.model.Manager");
		return mngs;
	}
	
	@Override
	@Transactional
	public void managerDel(int id) {
		Manager mng=this.getManagerByID(id);
		this.hibernateTemplate.delete(mng);
	}
	
	

	@Override
	@Transactional
	public void managerAdd(Manager manager) {
		
		this.hibernateTemplate.save(manager);
		Purview purview = new Purview();
		purview.setId(manager.getId());
		this.hibernateTemplate.save(purview);
		
	}

	@Override
	@Transactional
	public void managerAlter(Manager manager) {
		this.hibernateTemplate.update(manager);
		
	}

}
