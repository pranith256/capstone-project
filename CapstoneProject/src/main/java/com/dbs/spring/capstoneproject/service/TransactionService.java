package com.dbs.spring.capstoneproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.spring.capstoneproject.model.Transaction;
import com.dbs.spring.capstoneproject.repository.TransactionRepository;

@Service
public class TransactionService {
	public TransactionService() {
		
	}
	@Autowired
	private TransactionRepository repo;
	
	public List<Transaction> findallbid()
	{
		List<Transaction>  clients = new ArrayList<Transaction>();
		this.repo.findAll().forEach(tt->clients.add(tt));
		return clients;
	}

	public List<Transaction> findallbybuyscustodianid(String cid)
	{
		List<Transaction>  bclients = new ArrayList<Transaction>();

		this.repo.findAll().forEach((tt)->{
			System.out.println(tt);
			if(tt.getBuy_custodian().getCustodianid().equals(cid) ) {
				bclients.add(tt);
			}
			
		});
		return bclients;
	}
	public List<Transaction> findallbysellscustodianid(String cid)
	{
		List<Transaction>  sclients = new ArrayList<Transaction>();

		this.repo.findAll().forEach((tt)->{
			System.out.println(tt);
			if( tt.getSell_custodian().getCustodianid().equals(cid)){
				sclients.add(tt);
			}
		});
		return sclients;
	}
}
