package com.hwh.springmvc;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class Student {
	
	private int id;
	@NotEmpty
	private String name;
	@Past
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString(){
		return this.getName()+" "+this.getId()+" "+this.getDate()+"!";
	}
	
}
