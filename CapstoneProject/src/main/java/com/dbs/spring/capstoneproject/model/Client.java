package com.dbs.spring.capstoneproject.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Client {
	@Id
	private String clientid;
	private String clientname;
	private long transactionlimit;
	@ManyToOne
	@JoinColumn(name="custodianid")
	private Custodian custodian;
	public String getClientid() {
		return clientid;
	}
	public void setClientid(String clientid) {
		this.clientid = clientid;
	}
	public String getClientname() {
		return clientname;
	}
	public void setClientname(String clientname) {
		this.clientname = clientname;
	}
	public long getTransactionlimit() {
		return transactionlimit;
	}
	public void setTransactionlimit(long transactionlimit) {
		this.transactionlimit = transactionlimit;
	}
	public Custodian getCustodianid() {
		return custodian;
	}
	public void setCustodianid(Custodian custodianid) {
		this.custodian = custodianid;
	}
	public Client(String clientid, String clientname, long transactionlimit, Custodian custodianid) {
		super();
		this.clientid = clientid;
		this.clientname = clientname;
		this.transactionlimit = transactionlimit;
		this.custodian = custodianid;
	}
	public Client() {
		
	}
	
	

}
