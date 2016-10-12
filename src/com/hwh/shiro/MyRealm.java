package com.hwh.shiro;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.hwh.model.User;
import com.hwh.service.SysService;

public class MyRealm extends AuthorizingRealm {
	
	private SysService sysService;

	@Override
	public void setName(String name) {
		super.setName("customRealm");
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		
		String username = (String) token.getPrincipal();

		
		User user = null;
		try{
			user=this.sysService.getUser(username);
			if(user==null) return null;
		}catch(Exception e){
			return null;
		}
		
		
		String password = user.getPassword();
		
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
				username, password, this.getName());
	
		return simpleAuthenticationInfo;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		
		String username=  (String) principals.getPrimaryPrincipal();
		
		List<String> permissions = this.sysService.getPermissions(username);
		
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		simpleAuthorizationInfo.addStringPermissions(permissions);
		
		return simpleAuthorizationInfo;
	}
	
	
	public SysService getSysService() {
		return sysService;
	}
	
	@Autowired
	public void setSysService(SysService sysService) {
		this.sysService = sysService;
	}

	public void clearCached() {
		PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
		super.clearCache(principals);
	}  

}
