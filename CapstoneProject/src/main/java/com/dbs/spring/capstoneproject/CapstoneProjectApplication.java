package com.dbs.spring.capstoneproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.dbs.spring.capstoneproject.service.BuyService;
import com.dbs.spring.capstoneproject.service.SellService;

@SpringBootApplication
public class CapstoneProjectApplication {

	public static void main(String[] args) {
		//SpringApplication.run(CapstoneProjectApplication.class, args);
		ApplicationContext context= SpringApplication.run(CapstoneProjectApplication.class, args);
		//SpringApplication.run(OrdermatchingApplication.class, args);
		
//		System.out.println(ser.insertBuy());

	}

}
