package com.dbs.spring.capstoneproject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dbs.spring.capstoneproject.model.Client;

public interface ClientRepository extends CrudRepository<Client,String> {

   public List<Client> findAllByCustodianCustodianid(String cid);
}
