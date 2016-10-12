package com.hwh.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.hwh.dao.BookDAO;
import com.hwh.dao.ManagerDAO;
import com.hwh.model.Bookinfo;
import com.hwh.model.Manager;
import com.hwh.model.Purview;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

@Component
@Scope("prototype")
public class BookAction extends ActionSupport implements SessionAware{
	
	private Map<String, Object> session;
	private BookDAO bookDAO;

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session=arg0;
	}
	
	public String bookQuery(){
		List<Bookinfo> mngs=bookDAO.bookQuery();
		session.put("bookQuery", mngs);
		String mainPage="book.jsp";
		session.put("mainPage", mainPage);
		return Action.SUCCESS;
	}
	
	public String goadd(){
		String mainPage="book.jsp";
		session.put("mainPage", mainPage);
		return Action.SUCCESS;
	}
	
	public BookDAO getBookDAO() {
		return bookDAO;
	}
	@Resource(name="bookDAOImpl")
	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

	



	
}
