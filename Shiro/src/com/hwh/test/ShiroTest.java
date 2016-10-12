package com.hwh.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.mgt.SecurityManager;
import org.junit.Test;

public class ShiroTest {
	
	@Test
	public void testLoginAndLogout() {

		// 创建securityManager工厂，通过ini配置文件创建securityManager工厂
		//测试用默认的Realm
		/*Factory<SecurityManager> factory = new IniSecurityManagerFactory(
				"classpath:shiro-first.ini");*/
		//用指定的Reaml
		Factory<SecurityManager> factory = new IniSecurityManagerFactory(
				"classpath:shiro-realm.ini");
		//用指定的Reaml并加上md5()和salt
/*		Factory<SecurityManager> factory = new IniSecurityManagerFactory(
				"classpath:shiro-realm-md5.ini");*/
		
		//创建SecurityManager
		SecurityManager securityManager = (SecurityManager) factory.getInstance();
		
		//将securityManager设置当前的运行环境中
		SecurityUtils.setSecurityManager(securityManager);
		
		//从SecurityUtils里边创建一个subject
		Subject subject = SecurityUtils.getSubject();
		
		//在认证提交前准备token（令牌）
		UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "111111");

		try {
			//执行认证提交
			subject.login(token);
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//是否认证通过
		boolean isAuthenticated =  subject.isAuthenticated();
		
		System.out.println("是否认证通过：" + isAuthenticated);
		
		
		boolean isPermitted = subject.isPermitted("user:create:1");
		System.out.println("单个权限判断" + isPermitted);

		boolean isPermittedAll = subject.isPermittedAll("user:create:1",
				"user:create");
		System.out.println("多个权限判断" + isPermittedAll);

		// 使用check方法进行授权，如果授权不通过会抛出异常
		subject.checkPermission("items:add:1");
		
		
		//退出操作
		subject.logout();
		
		//是否认证通过
		isAuthenticated =  subject.isAuthenticated();
		
		System.out.println("是否认证通过：" + isAuthenticated);
		
		

	}
}
