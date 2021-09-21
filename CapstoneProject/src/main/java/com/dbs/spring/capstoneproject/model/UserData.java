package com.dbs.spring.capstoneproject.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class UserData {
	
	@Id
	private String  un;
	private String pass;
	public UserData(String un, String pass) {
		super();
		this.un = un;
		this.pass = pass;
	}
	public UserData() {
		super();
	}
	public String getUn() {
		return un;
	}
	public void setUn(String un) {
		this.un = un;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

}
