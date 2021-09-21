package com.dbs.spring.capstoneproject.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.spring.capstoneproject.model.Custodian;
import com.dbs.spring.capstoneproject.repository.CustodianRepository;

@Service
public class CustodianService {
	public CustodianService(){
		
	}
	@Autowired
	private CustodianRepository custrepo;
	public Custodian findcustodianid(String id)
	{
		try {
            Optional<Custodian> c=this.custrepo.findById(id);
            return c.orElseThrow(()->{
                return new EntityNotFoundException("Custodian with id "+id + " does not exist");
            });
            }
        catch(IllegalArgumentException iae) {
            return null;
	}
	
}
}
