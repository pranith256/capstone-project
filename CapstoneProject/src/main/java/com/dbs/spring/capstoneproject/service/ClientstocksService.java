package com.dbs.spring.capstoneproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.spring.capstoneproject.model.Client;
import com.dbs.spring.capstoneproject.model.Clientstocks;
import com.dbs.spring.capstoneproject.repository.ClientRepository;
import com.dbs.spring.capstoneproject.repository.ClientstocksRepository;

@Service
public class ClientstocksService {
	
	public ClientstocksService()
	{}
	@Autowired
	private ClientstocksRepository repo;
	public List<Clientstocks> findclientstocksbyid(String id)
	{
		List<Clientstocks>  clients = new ArrayList<Clientstocks>();
		this.repo.findAllByClientClientid(id).forEach(tt->clients.add(tt));
		return clients;
	}
	public Integer findquanbyid(String id) {
            return this.repo.findById(id).get().getQuantity();
  
	}
	public Clientstocks findclientstockid(String id)
	{
		try {
            Optional<Clientstocks> c=this.repo.findById(id);
            return c.orElseThrow(()->{
                return new EntityNotFoundException("Client with id "+id + " does not exist");
            });
            }
        catch(IllegalArgumentException iae) {
            return null;
	}
		
	}
}

