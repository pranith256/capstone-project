package com.dbs.spring.capstoneproject.rest;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.spring.capstoneproject.model.Client;
import com.dbs.spring.capstoneproject.service.ClientService;


@CrossOrigin
@RestController
@RequestMapping("/client")
public class ClientController {

	public ClientController()
	{}
	@Autowired
	private ClientService service;
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Object> getClientById(@PathVariable String id)
	{
		try {
            Client b=this.service.findclientid(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(b);
        }
        catch(EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(e.getMessage());
        }
	}
	@GetMapping("/cid/{cid}")
	public List<Client> getClientByCustodianId(@PathVariable String cid)
	{
		return this.service.getAllById(cid);
	}
	
	@GetMapping("")
	public List<Client> getAll()
	{
		return this.service.getAll();
	}
	
}
