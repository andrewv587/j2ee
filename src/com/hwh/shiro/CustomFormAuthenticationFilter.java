package com.hwh.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import com.google.code.kaptcha.Constants;

public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {

	@Override
	protected boolean onAccessDenied(ServletRequest request,
			ServletResponse response) throws Exception {
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpSession session =httpServletRequest.getSession();
		
		String validateCode = (String)session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		
		String randomcode = httpServletRequest.getParameter("randomcode");
		/*if(randomcode!=null && validateCode!=null && !randomcode.equals(validateCode)){
			httpServletRequest.setAttribute("shiroLoginFailure", "randomCodeError");
			return true; 
		}*/
		return super.onAccessDenied(request, response);
	}
		
}
