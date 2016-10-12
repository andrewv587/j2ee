package com.hwh.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="tb_publishing")
public class Publishing {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String ISBN;
	private String pubname;

	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getPubname() {
		return pubname;
	}
	public void setPubname(String pubname) {
		this.pubname = pubname;
	}
}
