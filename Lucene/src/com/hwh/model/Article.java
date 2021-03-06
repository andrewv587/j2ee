package com.hwh.model;

public class Article {
	private int id;
	private String name;
	private String context;
	
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

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	@Override
	public String toString() {
		return this.id+" "+this.name +" " +this.context;
	}

	
	
	
}
