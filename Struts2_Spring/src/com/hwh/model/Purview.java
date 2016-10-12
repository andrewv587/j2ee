package com.hwh.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="tb_purview")
public class Purview {
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int sysset;
	private int readerset;
	private int bookset;
	private int borrowback;
	private int sysquery;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSysset() {
		return sysset;
	}
	public void setSysset(int sysset) {
		this.sysset = sysset;
	}

	public int getBookset() {
		return bookset;
	}
	public void setBookset(int bookset) {
		this.bookset = bookset;
	}
	public int getBorrowback() {
		return borrowback;
	}
	public void setBorrowback(int borrowback) {
		this.borrowback = borrowback;
	}
	public int getSysquery() {
		return sysquery;
	}
	public void setSysquery(int sysquery) {
		this.sysquery = sysquery;
	}
	public int getReaderset() {
		return readerset;
	}
	public void setReaderset(int readerset) {
		this.readerset = readerset;
	}
}
