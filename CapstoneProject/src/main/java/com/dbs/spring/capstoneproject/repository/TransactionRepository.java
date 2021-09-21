package com.dbs.spring.capstoneproject.repository;

import org.springframework.data.repository.CrudRepository;

import com.dbs.spring.capstoneproject.model.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction,Integer> {

}
