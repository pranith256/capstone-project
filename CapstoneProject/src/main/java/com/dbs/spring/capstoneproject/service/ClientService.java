package com.dbs.spring.capstoneproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.spring.capstoneproject.model.Client;
import com.dbs.spring.capstoneproject.model.Custodian;
import com.dbs.spring.capstoneproject.repository.ClientRepository;
import com.dbs.spring.capstoneproject.repository.CustodianRepository;

@Service
public class ClientService {
	public ClientService()
	{}
	@Autowired
	private ClientRepository repo;
	public Client findclientid(String id)
	{
		try {
            Optional<Client> c=this.repo.findById(id);
            return c.orElseThrow(()->{
                return new EntityNotFoundException("Client with id "+id + " does not exist");
            });
            }
        catch(IllegalArgumentException iae) {
            return null;
	}
	
}
	public List<Client> getAllById(String cid) {
		List<Client>  clients = new ArrayList<Client>();
		this.repo.findAllByCustodianCustodianid(cid).forEach(tt->clients.add(tt));
		return clients;
}
	public List<Client> getAll() {
		// TODO Auto-generated method stub
		List<Client>  clients = new ArrayList<Client>();
		this.repo.findAll().forEach(tt->clients.add(tt));
		return clients;

	}


}
