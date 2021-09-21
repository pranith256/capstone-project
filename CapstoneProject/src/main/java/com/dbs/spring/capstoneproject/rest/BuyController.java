package com.dbs.spring.capstoneproject.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.spring.capstoneproject.model.Buy;
import com.dbs.spring.capstoneproject.service.BuyService;

@CrossOrigin
@RestController
@RequestMapping("/buy")
public class BuyController {
	

	public BuyController()
	{
	
	}
	
	@Autowired
    private BuyService service;
    @GetMapping("/{id}")
    public List<Buy> getStocks(@PathVariable String id){
        return this.service.findsalebuysbyid(id);
    }
    
    @GetMapping("/all")
    public List<Buy> findallstocks(){
        return this.service.findallbid();
    }
    
    
    @PostMapping
    public ResponseEntity<Object> insertbuy(@RequestBody Buy buy) {
    	
    	String cid=buy.getClient().getClientid();
    	String iid=buy.getInstrument().getInstrumentid();
    	int p=buy.getPrice();
    	int q=buy.getQuantity();
    	int bid=this.service.insertBuy(cid, iid, p, q);
    	if(bid>=1)
    	{
    		return ResponseEntity.status(HttpStatus.OK).body(service.findbyid(bid));
    	}
    	else
    	{
    		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("This bid does not exist");
    	}
    }
    
	
}
