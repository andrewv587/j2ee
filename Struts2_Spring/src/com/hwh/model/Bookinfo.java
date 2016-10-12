package com.hwh.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="tb_bookinfo")
public class Bookinfo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String barcode;
	private String bookname;
	private String author;
	private String translator;
	private String price;
	@Column(name="inTime")
	private Date date;
	private int del;
	private String operator;

	@ManyToOne( cascade =CascadeType.ALL)
	@JoinColumn(name="bookcase")
	private Bookcase bookcase;
	@ManyToOne( cascade =CascadeType.ALL)
	@JoinColumn(name="ISBN")
	private Publishing publishing;
	@ManyToOne( cascade =CascadeType.ALL)
	@JoinColumn(name="typeid")
	private Booktype booktype;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTranslator() {
		return translator;
	}
	public void setTranslator(String translator) {
		this.translator = translator;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getDel() {
		return del;
	}
	public void setDel(int del) {
		this.del = del;
	}

	public Bookcase getBookcase() {
		return bookcase;
	}
	public void setBookcase(Bookcase bookcase) {
		this.bookcase = bookcase;
	}
	public Publishing getPublishing() {
		return publishing;
	}
	public void setPublishing(Publishing publishing) {
		this.publishing = publishing;
	}
	public Booktype getBooktype() {
		return booktype;
	}
	public void setBooktype(Booktype booktype) {
		this.booktype = booktype;
	}
	
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
}
