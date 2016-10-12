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

		// ����securityManager������ͨ��ini�����ļ�����securityManager����
		//������Ĭ�ϵ�Realm
		/*Factory<SecurityManager> factory = new IniSecurityManagerFactory(
				"classpath:shiro-first.ini");*/
		//��ָ����Reaml
		Factory<SecurityManager> factory = new IniSecurityManagerFactory(
				"classpath:shiro-realm.ini");
		//��ָ����Reaml������md5()��salt
/*		Factory<SecurityManager> factory = new IniSecurityManagerFactory(
				"classpath:shiro-realm-md5.ini");*/
		
		//����SecurityManager
		SecurityManager securityManager = (SecurityManager) factory.getInstance();
		
		//��securityManager���õ�ǰ�����л�����
		SecurityUtils.setSecurityManager(securityManager);
		
		//��SecurityUtils��ߴ���һ��subject
		Subject subject = SecurityUtils.getSubject();
		
		//����֤�ύǰ׼��token�����ƣ�
		UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "111111");

		try {
			//ִ����֤�ύ
			subject.login(token);
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//�Ƿ���֤ͨ��
		boolean isAuthenticated =  subject.isAuthenticated();
		
		System.out.println("�Ƿ���֤ͨ����" + isAuthenticated);
		
		
		boolean isPermitted = subject.isPermitted("user:create:1");
		System.out.println("����Ȩ���ж�" + isPermitted);

		boolean isPermittedAll = subject.isPermittedAll("user:create:1",
				"user:create");
		System.out.println("���Ȩ���ж�" + isPermittedAll);

		// ʹ��check����������Ȩ�������Ȩ��ͨ�����׳��쳣
		subject.checkPermission("items:add:1");
		
		
		//�˳�����
		subject.logout();
		
		//�Ƿ���֤ͨ��
		isAuthenticated =  subject.isAuthenticated();
		
		System.out.println("�Ƿ���֤ͨ����" + isAuthenticated);
		
		

	}
}
