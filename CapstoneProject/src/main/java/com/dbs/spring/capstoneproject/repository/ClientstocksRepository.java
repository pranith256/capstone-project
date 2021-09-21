package com.dbs.spring.capstoneproject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dbs.spring.capstoneproject.model.Clientstocks;

public interface ClientstocksRepository extends CrudRepository<Clientstocks,String> {
	
	public List<Clientstocks> findAllByClientClientid(String id);

}
