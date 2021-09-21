package com.dbs.spring.capstoneproject.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.spring.capstoneproject.model.Transaction;
import com.dbs.spring.capstoneproject.service.TransactionService;

@CrossOrigin
@RestController
@RequestMapping("/history")
public class TransactionController {

	public TransactionController()
	{
	
	}
	
	@Autowired
    private TransactionService service;


    @GetMapping("/all")
    public List<Transaction> findallstocks(){
        return this.service.findallbid();
    }
    
    @GetMapping("/buys/{cid}")
    public List<Transaction> findAllbyBuysCustodianId(@PathVariable String cid)
    {
    	return this.service.findallbybuyscustodianid(cid);
    }
    @GetMapping("/sells/{cid}")
    public List<Transaction> findAllbySellsCustodianId(@PathVariable String cid)
    {
    	return this.service.findallbysellscustodianid(cid);
    }
}
