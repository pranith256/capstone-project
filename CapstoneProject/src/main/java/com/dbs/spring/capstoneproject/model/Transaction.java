package com.dbs.spring.capstoneproject.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tid;
	@ManyToOne
	@JoinColumn(name="buy_custodianid")
	private Custodian buy_custodian;
	@ManyToOne
	@JoinColumn(name="sell_custodianid")
	private Custodian sell_custodian;
	@ManyToOne
	@JoinColumn(name="instrumentid")
	private Instruments instrument;

	@ManyToOne
	@JoinColumn(name="buyerid")
	private Client buyer;

	@ManyToOne
	@JoinColumn(name="sellerid")
	private Client seller;
	private int quantity;
	private int price;
	private LocalDateTime date;
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public Custodian getBuy_custodian() {
		return buy_custodian;
	}
	public void setBuy_custodian(Custodian buy_custodian) {
		this.buy_custodian = buy_custodian;
	}
	public Custodian getSell_custodian() {
		return sell_custodian;
	}
	public void setSell_custodian(Custodian sell_custodian) {
		this.sell_custodian = sell_custodian;
	}
	public Instruments getInstrument() {
		return instrument;
	}
	public void setInstrument(Instruments instrument) {
		this.instrument = instrument;
	}
	public Client getBuyer() {
		return buyer;
	}
	public void setBuyer(Client buyer) {
		this.buyer = buyer;
	}
	public Client getSeller() {
		return seller;
	}
	public void setSeller(Client seller) {
		this.seller = seller;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public Transaction() {
		//super();
		// TODO Auto-generated constructor stub
	}
	public Transaction(int tid, Custodian buy_custodian, Custodian sell_custodian, Instruments instrument, Client buyer,
			Client seller, int quantity, int price, LocalDateTime date) {
		super();
		this.tid = tid;
		this.buy_custodian = buy_custodian;
		this.sell_custodian = sell_custodian;
		this.instrument = instrument;
		this.buyer = buyer;
		this.seller = seller;
		this.quantity = quantity;
		this.price = price;
		this.date = date;
	}
	
	
	
	

}
