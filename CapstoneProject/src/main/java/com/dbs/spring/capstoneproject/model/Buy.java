package com.dbs.spring.capstoneproject.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.sound.midi.Instrument;

@Entity
public class Buy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int buyid;
	@ManyToOne
	@JoinColumn(name="clientid")
	private Client client;
	@ManyToOne
	@JoinColumn(name="instrumentid")
	private Instruments instrument;
	private int quantity;
	private int rem_quantity;
	private int price;
	private LocalDateTime date;
	private String status;
	public int getBuyid() {
		return buyid;
	}
	public void setBuyid(int buyid) {
		this.buyid = buyid;
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

	public Buy() {
	
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getRem_quantity() {
		return rem_quantity;
	}
	public void setRem_quantity(int rem_quantity) {
		this.rem_quantity = rem_quantity;
	}
	public Buy(int buyid, Client client, Instruments instrument, int quantity, int rem_quantity, int price,
			LocalDateTime date, String status) {
		super();
		this.buyid = buyid;
		this.client = client;
		this.instrument = instrument;
		this.quantity = quantity;
		this.rem_quantity = rem_quantity;
		this.price = price;
		this.date = date;
		this.status = status;
	}
	

}
