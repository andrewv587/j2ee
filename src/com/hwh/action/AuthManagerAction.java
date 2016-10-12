package com.hwh.action;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AuthManagerAction {
	
	@RequestMapping("/auth")
	@RequiresPermissions("userManager")
	public String authAdd(){
		return "authMng";
	}
	
	@RequestMapping("/book")
	@RequiresPermissions("bookManager")
	public String bookAdd(){
		return "bookMng";
	}
}
