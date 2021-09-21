package com.dbs.spring.capstoneproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.dbs.spring.capstoneproject.model.Buy;
import com.dbs.spring.capstoneproject.model.Clientstocks;
import com.dbs.spring.capstoneproject.model.Sell;

public interface BuyRepository extends CrudRepository<Buy,Integer> {

	public List<Buy> findAllByClientClientid(String id);
	
	@Query(value="SELECT * from sell s where s.instrumentid= :inst and s.price= :p and s.status='pending' and s.rem_quantity>0 order by s.date; ",nativeQuery = true)
	public List<Integer> bOrderMatching(@Param("inst") String inst,
			@Param("p") int p);
}
