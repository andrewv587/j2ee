package www.hwh.struts;

import com.opensymphony.xwork2.ActionSupport;

public class Action04 extends ActionSupport{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	 public String execute() throws Exception {
		System.out.println(this.name);
        return SUCCESS;
    }
}
