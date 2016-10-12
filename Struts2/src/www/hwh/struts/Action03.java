package www.hwh.struts;

import com.opensymphony.xwork2.ActionSupport;

public class Action03 extends ActionSupport{
	
	public String add(){
		System.out.println("add");
		return SUCCESS;
	}
	
	public String delete(){
		System.out.println("Delete");
		return SUCCESS;
	}
}
