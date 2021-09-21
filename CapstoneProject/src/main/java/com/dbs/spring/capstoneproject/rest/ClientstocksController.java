package com.dbs.spring.capstoneproject.rest;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.spring.capstoneproject.model.Client;
import com.dbs.spring.capstoneproject.model.Clientstocks;
import com.dbs.spring.capstoneproject.model.Instruments;
import com.dbs.spring.capstoneproject.service.ClientstocksService;
import com.dbs.spring.capstoneproject.service.InstrumentsService;


@CrossOrigin
@RestController
@RequestMapping("/stocks")
public class ClientstocksController {
	@Autowired
    private ClientstocksService service;
    @GetMapping("/{id}")
    public List<Clientstocks> getStocks(@PathVariable String id){
        return this.service.findclientstocksbyid(id);
    }
	
	@GetMapping("/quan")
	public ResponseEntity<Object> getClientById(@RequestParam String cid,@RequestParam String id)
	{
		String ciid= cid+id;
		System.out.println(ciid);
		System.out.println(id);
		System.out.println(cid);
		try {
            Clientstocks b=this.service.findclientstockid(ciid);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(b);
        }
        catch(EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(e.getMessage());
        }
		
	}
//	public int findquan(String id)
//	{
//		return service.findquanbyid(id);
//	}

}
