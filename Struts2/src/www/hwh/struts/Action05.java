package www.hwh.struts;

import com.opensymphony.xwork2.ActionSupport;

public class Action05 extends ActionSupport{
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	 public String execute() throws Exception {
		System.out.println(this.user.getAge());
		System.out.println(this.user.getName());
        return SUCCESS;
    }
}
