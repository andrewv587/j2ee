package www.hwh.struts;

import com.opensymphony.xwork2.ActionSupport;

public class Action07 extends ActionSupport {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String execute() throws Exception {
		if (name.equals("HelloWorld")) {
			System.out.println("Yes");
			return SUCCESS;
		} else
			return ERROR;
	}

}
