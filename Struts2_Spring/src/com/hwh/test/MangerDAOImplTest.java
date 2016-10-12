package com.hwh.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hwh.dao.BookDAO;
import com.hwh.dao.ManagerDAO;
import com.hwh.dao.impl.ManagerDAOImpl;
import com.hwh.model.Bookinfo;
import com.hwh.model.Manager;
import com.hwh.model.Purview;



public class MangerDAOImplTest {

	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		//ManagerDAO mngDAO = context.getBean("managerDAOImpl", ManagerDAO.class);
		BookDAO bookDAO = context.getBean("bookDAOImpl", BookDAO.class);
		List<Bookinfo> bookinfos=bookDAO.bookQuery();
		System.out.println(bookinfos.get(0).getBookcase().getColumn());
	
/*		Manager manager=new Manager();
		manager.setName("adcd");
		manager.setPassword("111");
		mngDAO.managerAdd(manager);
		*/
		//mngDAO.managerDel(id);
/*		Manager mng=mngDAO.getManager(manager);
		//Purview purview=mngDAO.getPurview(mng);
		System.out.println(mng.getPurview().getId());
		System.out.println(mng.getPurview().getBookset());
		System.out.println(mng);
		
		mngDAO.managerDel(6);
		int sz=mngDAO.managerQuery().size();
		System.out.println("size= "+sz);
		*/
	}

}
