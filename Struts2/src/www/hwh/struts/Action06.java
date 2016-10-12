package www.hwh.struts;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class Action06 extends ActionSupport implements SessionAware,RequestAware,ApplicationAware{
	
	private Map<String, Object> application;
	private Map<String, Object> request;
	private Map<String, Object> session;
	
	
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	 public String execute() throws Exception {
		this.application.put("a", "aa");
		this.request.put("r", "rr");
		this.session.put("s","ss");
        return SUCCESS;
    }

	@Override
	public void setApplication(Map<String, Object> application) {
		this.application=application;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request=request;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
	
	
}
