package com.hwh.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/*@Entity*/
public class Wife {
/*	@Id
	@GeneratedValue*/
	private int wife_id;
	private String wife_name;
	//@OneToOne(mappedBy="wife")
	//private Husband husband;
	public int getWife_id() {
		return wife_id;
	}
	public void setWife_id(int wife_id) {
		this.wife_id = wife_id;
	}
	public String getWife_name() {
		return wife_name;
	}
	public void setWife_name(String wife_name) {
		this.wife_name = wife_name;
	}
	

	
}
