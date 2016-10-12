package com.hwh.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hwh.model.JsonModel;
import com.hwh.model.User;
import com.hwh.service.SysService;

public class SysServiceTest {
	
	private static ApplicationContext context = new ClassPathXmlApplicationContext(
			"classpath:config/spring.xml");
	
	@Test
	public void test1() {
		SysService sysService = context.getBean("sysService", SysService.class);
		User user = (User) sysService.getUser("hwh");
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		List<String> permissions = sysService.getPermissions("hwh");
		for(String permission :  permissions){
			System.out.println(permission);
		}
	}
	
	@Test
	public void test2(){
		SysService sysService = context.getBean("sysService", SysService.class);
		//List<User> users = service.findAllUser();
		/*List<User> users = service.paginationUser(1, 5);
		for(User user : users){
			System.out.println(user.getUsername());
			System.out.println(user.getPassword());
		}*/
		int first =1;
		int pageSize=5;
		System.out.println(sysService.findUserNum());
		System.out.println(first+" "+pageSize);
		int total = sysService.findUserNum();
		List<User> users = sysService.paginationUser(first, pageSize);
		JsonModel<User> juser = new JsonModel<User>();
		juser.setTotal(total);
		juser.setRows(users);
		System.out.println(juser.getTotal());
		
		int id=18;
		String flag="success";
		System.out.println(id);
		System.out.println("ok");
		User user = new User();
		user.setId(id);
		try{
			sysService.deleteUser(user);
		}catch(Exception ex){
			ex.printStackTrace();
			flag= "failed";
		}
	
		System.out.println(flag);
		/*User new_user=new User();
		new_user.setId(10);
		new_user.setUsername("def");
		new_user.setAge(10);
		new_user.setPassword("aasdf");
		//service.saveUser(new_user);
		//service.deleteUser(new_user);
		User user = service.getUser("hwh");
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		//System.out.println(saveOk);
*/	}
	
	@Test
	public void test3(){
		SysService sysService = context.getBean("sysService", SysService.class);
		User user = new User();
		//user.setId(11);
		user.setAge(14);
		user.setUsername("hwhaa");
		System.out.println(user);
		User sql_user = sysService.getUserById(user.getId());
		String password="123";
		if(sql_user!=null) {
			password = sql_user.getPassword();
		}
		user.setPassword(password);
		try{
			sysService.saveOrUpdateUser(user);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
}
