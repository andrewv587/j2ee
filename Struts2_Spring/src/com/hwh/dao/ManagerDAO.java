package com.hwh.dao;

import java.util.List;

import com.hwh.model.Manager;
import com.hwh.model.Purview;

public interface ManagerDAO {
	Manager getManager(Manager manager);
	List<Manager> managerQuery();
	void managerDel(int id);
	void managerAdd(Manager manager);
	Manager getManagerByID(int id);
	void managerAlter(Manager manager);
}
