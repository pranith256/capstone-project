package com.dbs.spring.capstoneproject.rest;

import javax.persistence.EntityNotFoundException;

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

import com.dbs.spring.capstoneproject.model.Custodian;
import com.dbs.spring.capstoneproject.model.UserData;
import com.dbs.spring.capstoneproject.service.CustodianService;


@CrossOrigin
@RestController
@RequestMapping
public class CustodianController {

	public CustodianController()
	{
		
	}
	@Autowired
	private CustodianService service;
		
	@GetMapping("/custodian/{id}")
	public ResponseEntity<Object> getClientById(@PathVariable String id)
	{
		try {
            Custodian b=this.service.findcustodianid(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(b);
        }
        catch(EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(e.getMessage());
        }
	}

	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody UserData user)
	{
		try {
	
		Custodian cu= this.service.findcustodianid(user.getUn());
		if(cu.getCustodianid().equals(user.getUn()) && cu.getPassword().equals(user.getPass())) {
			return ResponseEntity.status(HttpStatus.OK)
                    .body(cu);
		}
		

		else { return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("not found");
		
	
		}
		}
		catch(EntityNotFoundException e)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("error logging in ");
		}
	}

}
