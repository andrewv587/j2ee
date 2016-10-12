package com.hwh.realm;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class CustomRealm extends AuthorizingRealm {

	// ����realm������
	@Override
	public void setName(String name) {
		super.setName("customRealm");
	}

	// ������֤
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {

		// token���û������
		// ��һ����token��ȡ�������Ϣ
		String userCode = (String) token.getPrincipal();

		// �ڶ����������û������userCode�����ݿ��ѯ
		// ....
	

		// �����ѯ��������null
		//���ݿ����û��˺���zhangsansan
	/*	if(!userCode.equals("zhangsansan")){//
			return null;
		}*/
		
		// ģ������ݿ��ѯ������
		String password = "111111";

		// �����ѯ��������֤��ϢAuthenticationInfo

		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
				userCode, password, this.getName());

		return simpleAuthenticationInfo;
	}

	// ������Ȩ
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		
		//�� principals��ȡ�������Ϣ
		//��getPrimaryPrincipal��������ֵתΪ��ʵ������ͣ����ϱߵ�doGetAuthenticationInfo��֤ͨ����䵽SimpleAuthenticationInfo��������ͣ���
		String userCode =  (String) principals.getPrimaryPrincipal();
		
		//���������Ϣ��ȡȨ����Ϣ
		//�������ݿ�...
		//ģ������ݿ��ȡ������
		List<String> permissions = new ArrayList<String>();
		permissions.add("user:create");//�û��Ĵ���
		permissions.add("items:add");//��Ʒ���Ȩ��
		//....
		
		//�鵽Ȩ�����ݣ�������Ȩ��Ϣ(Ҫ���� �ϱߵ�permissions)
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		//���ϱ߲�ѯ����Ȩ��Ϣ��䵽simpleAuthorizationInfo������
		simpleAuthorizationInfo.addStringPermissions(permissions);

		return simpleAuthorizationInfo;
	}

}
