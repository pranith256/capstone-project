package com.dbs.spring.capstoneproject.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Instruments {
	@Id
	private String instrumentid;
	private String instrumentname;
	private int  facevalue;
	private double price;
	private int minquantity;
	private LocalDate date;
	public String getInstrumentid() {
		return instrumentid;
	}
	public void setInstrumentid(String instrumentid) {
		this.instrumentid = instrumentid;
	}
	public String getInstrumentname() {
		return instrumentname;
	}
	public void setInstrumentname(String instrumentname) {
		this.instrumentname = instrumentname;
	}
	public int getFacevalue() {
		return facevalue;
	}
	public void setFacevalue(int facevalue) {
		this.facevalue = facevalue;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getMinquantity() {
		return minquantity;
	}
	public void setMinquantity(int minquantity) {
		this.minquantity = minquantity;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Instruments(String instrumentid, String instrumentname, int facevalue, double price, int minquantity,
			LocalDate date) {
		super();
		this.instrumentid = instrumentid;
		this.instrumentname = instrumentname;
		this.facevalue = facevalue;
		this.price = price;
		this.minquantity = minquantity;
		this.date = date;
	}
	public Instruments() {
		
	}
	
	

}
