package com.dbs.spring.capstoneproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Clientstocks {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String customerid_instruemntid;
	@ManyToOne
	@JoinColumn(name="clientid")
	private Client client;
	@ManyToOne
	@JoinColumn(name="instrumentid")
	private Instruments instrument;

	private int quantity;
	private String instrumentname;
	public String getCustomerid_instruemntid() {
		return customerid_instruemntid;
	}
	public void setCustomerid_instruemntid(String customerid_instruemntid) {
		this.customerid_instruemntid = customerid_instruemntid;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Instruments getInstrument() {
		return instrument;
	}
	public void setInstrument(Instruments instrument) {
		this.instrument = instrument;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Clientstocks(String customerid_instruemntid, Client client, Instruments instrument, int quantity,
			String instrumentname) {
		super();
		this.customerid_instruemntid = customerid_instruemntid;
		this.client = client;
		this.instrument = instrument;
		this.quantity = quantity;
		this.instrumentname = instrumentname;
	}
	public Clientstocks() {
		//super();
		// TODO Auto-generated constructor stub
	}
	public String getInstrumentname() {
		return instrumentname;
	}
	public void setInstrumentname(String instrumentname) {
		this.instrumentname = instrumentname;
	}
		
}
