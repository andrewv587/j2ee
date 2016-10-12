package com.hwh.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.hwh.dao.ManagerDAO;
import com.hwh.model.Manager;
import com.hwh.model.Purview;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

@Component
@Scope("prototype")
public class ManagerAction extends ActionSupport implements SessionAware{
	private Map<String, Object> session;
	private Manager manager;
	private Purview purview;
	private int id;
	private ManagerDAO managerDAO;
	
	public String login(){
		if(session.get("manager")!=null){
			String mainPage="default.jsp";
			session.put("mainPage", mainPage);
			return Action.SUCCESS;
		}
		if(manager==null) return Action.ERROR;
		Manager mng = managerDAO.getManager(manager);
		if(mng==null) {
			return Action.ERROR;
		}
		session.put("manager", mng);
		String mainPage="default.jsp";
		session.put("mainPage", mainPage);
		return Action.SUCCESS;
	}
	
	public String managerQuery(){
		List<Manager> mngs=managerDAO.managerQuery();
		session.put("managerQuery", mngs);
		String mainPage="manager.jsp";
		session.put("mainPage", mainPage);
		return Action.SUCCESS;
	}
	
	public String managerDel(){
		managerDAO.managerDel(id);
		List<Manager> mngs=managerDAO.managerQuery();
		session.put("managerQuery", mngs);
		String mainPage="manager.jsp";
		session.put("mainPage", mainPage);
		return Action.SUCCESS;
	}
	
	public String managergoAdd() {
		String mainPage = "manager_add.jsp";
		session.put("mainPage", mainPage);
		return Action.SUCCESS;
	}
	
	public String managerAdd(){
		managerDAO.managerAdd(manager);
		List<Manager> mngs=managerDAO.managerQuery();
		session.put("managerQuery", mngs);
		String mainPage="manager.jsp";
		session.put("mainPage", mainPage);
		return Action.SUCCESS;
	}
	
	public String managerModifyQuery(){
		Manager mng=managerDAO.getManagerByID(id);
		session.put("manager_modify", mng);
		String mainPage="manager_modify.jsp";
		session.put("mainPage", mainPage);
		return Action.SUCCESS;
	}
	
	public String managerModify(){
		this.purview.setId(this.manager.getId());
		this.manager.setPurview(purview);
		managerDAO.managerAlter(manager);
		String mainPage="manager.jsp";
		session.put("mainPage", mainPage);
		List<Manager> mngs=managerDAO.managerQuery();
		session.put("managerQuery", mngs);
		return Action.SUCCESS;
	}
	
	public String altergopwd(){
		session.put("mainPage", "pwd_modify.jsp");
		return Action.SUCCESS;
	}
	
	public String modifypwd(){
		managerDAO.managerAlter(manager);
		List<Manager> mngs=managerDAO.managerQuery();
		session.put("managerQuery", mngs);
		String mainPage="default.jsp";
		session.put("mainPage", mainPage);
		return Action.SUCCESS;
	}
	

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session=arg0;
	}
	

	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public ManagerDAO getManagerDAO() {
		return managerDAO;
	}
	
	@Resource(name="managerDAOImpl")
	public void setManagerDAO(ManagerDAO managerDAO) {
		this.managerDAO = managerDAO;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Purview getPurview() {
		return purview;
	}

	public void setPurview(Purview purview) {
		this.purview = purview;
	}


	
}
