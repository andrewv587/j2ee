package www.hwh.struts;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.hwh.model.User;
import com.hwh.service.UserService;
import com.opensymphony.xwork2.Action;

@Component("action01")
@Scope("prototype")
public class Action01 implements Action{
	
	private UserService userService;
	@Override
	public String execute() throws Exception {
		User user = new User();
		user.setName("abc");
		this.userService.add(user);
		return Action.SUCCESS;
	}
	
	public UserService getUserService() {
		return userService;
	}
	
	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
