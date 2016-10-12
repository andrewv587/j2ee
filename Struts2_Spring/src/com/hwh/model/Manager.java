package com.hwh.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name="tb_manager")
public class Manager {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Column(name="PWD")
	private String password;
	
	@OneToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)  
	@PrimaryKeyJoinColumn
	private Purview purview;
	
	
	public Purview getPurview() {
		return purview;
	}
	public void setPurview(Purview purview) {
		this.purview = purview;
	}
	
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "["+this.getId()+","+this.getName()+","+this.getPassword()+"]";
	}
	
}
