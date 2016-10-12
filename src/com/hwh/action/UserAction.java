package com.hwh.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hwh.model.JsonModel;
import com.hwh.model.User;
import com.hwh.service.SysService;

@Controller
@RequestMapping("/user")
public class UserAction {

	private SysService sysService;

	@RequestMapping("/*")
	public String userShow() {
		return "user";
	}

	@ResponseBody
	@RequestMapping("/getUsers")
	public JsonModel<User> getUsers(@RequestParam(value = "page") int first,
			@RequestParam(value = "rows") int pageSize) {
		int total = this.sysService.findUserNum();
		List<User> users = this.sysService.paginationUser(first, pageSize);
		JsonModel<User> juser = new JsonModel<User>();
		juser.setTotal(total);
		juser.setRows(users);
		return juser;
	}

	@ResponseBody
	@RequestMapping("/deleteUser")
	public String deleteUser(@RequestParam(value = "id") int id) {
		User user = new User();
		user.setId(id);
		try {
			this.sysService.deleteUser(user);
		} catch (Exception ex) {
			return "failed";
		}
		return "success";
	}

	@ResponseBody
	@RequestMapping("/updateUser")
	public String updateUser(User user) {
		User sql_user = this.sysService.getUserById(user.getId());
		List<User> users = this.sysService.findAllUser();
		if (users != null) {
			for (User tmp_user : users) {
				if (tmp_user.getUsername().equals(user.getUsername())) {
					if(tmp_user.getId()!=user.getId())
						return "name_false";
				}
			}
		}
		String password = "123";
		if (sql_user != null) {
			password = sql_user.getPassword();
		}
		user.setPassword(password);
		try {
			this.sysService.saveOrUpdateUser(user);
		} catch (Exception ex) {
			return "failed";
		}
		return "success";
	}

	@ResponseBody
	@RequestMapping("/saveUser")
	public String saveUser(User user) {
		List<User> users = this.sysService.findAllUser();
		if (users != null) {
			for (User tmp_user : users) {
				if (tmp_user.getId() == user.getId()) {
					return "id_false";
				} else if (tmp_user.getUsername().equals(user.getUsername())) {
					return "name_false";
				}
			}
		}
		String password = "123";
		user.setPassword(password);
		try {
			this.sysService.saveUser(user);
		} catch (Exception ex) {
			ex.printStackTrace();
			return "failed";
		}
		return "success";
	}

	public SysService getSysService() {
		return sysService;
	}

	@Autowired
	public void setSysService(SysService sysService) {
		this.sysService = sysService;
	}

}
