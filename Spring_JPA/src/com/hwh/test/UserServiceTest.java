package com.hwh.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hwh.dao.UserDAO;
import com.hwh.model.User;
import com.hwh.service.UserService;

public class UserServiceTest {

	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"annotation.xml");
		
		UserService userService= context.getBean("userService",UserService.class);
		
		User user = new User();
		//user.setId(5);
		user.setName("abc");
		user.setName("hwh");

		userService.add(user);

	}

}
