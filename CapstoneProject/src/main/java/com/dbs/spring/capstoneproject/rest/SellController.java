

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
import com.dbs.spring.capstoneproject.model.Sell;
import com.dbs.spring.capstoneproject.service.SellService;
import com.dbs.spring.capstoneproject.service.SellService;

@CrossOrigin
@RestController
@RequestMapping("/sell")
public class SellController {
	

	public SellController()
	{
	
	}
	
	@Autowired
    private SellService service;
    @GetMapping("/{id}")
    public List<Sell> getStocks(@PathVariable String id){
        return this.service.findsaleSellsbyid(id);
    }
    
    @GetMapping("/all")
    public List<Sell> findallstocks(){
        return this.service.findallbid();
    }
    @PostMapping
    public ResponseEntity<Object> insertbuy(@RequestBody Sell sell) {
    	
    	String cid=sell.getClient().getClientid();
    	String iid=sell.getInstrument().getInstrumentid();
    	int p=sell.getPrice();
    	int q=sell.getQuantity();
    	int sid=this.service.insertSell(cid, iid, p, q);
    	if(sid>=1)
    	{
    		return ResponseEntity.status(HttpStatus.OK).body(service.findbyid(sid));
    	}
    	else
    	{
    		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("This sid does not exist");
    	}
    }

    
	
}
