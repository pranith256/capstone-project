package com.dbs.spring.capstoneproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.dbs.spring.capstoneproject.model.Buy;
import com.dbs.spring.capstoneproject.model.Sell;

public interface SellRepository extends CrudRepository<Sell,Integer> {

	public List<Sell> findAllByClientClientid(String id);
	
	@Query(value="SELECT * from buy b where b.instrumentid= :inst and b.price= :p and b.status='pending' and b.rem_quantity>0 order by b.date; ",nativeQuery = true)
	public List<Integer> sOrderMatching(@Param("inst") String inst,
			@Param("p") int p);
}
