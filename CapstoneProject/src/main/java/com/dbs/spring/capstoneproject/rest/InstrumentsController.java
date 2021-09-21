package com.dbs.spring.capstoneproject.rest;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.spring.capstoneproject.model.Instruments;
import com.dbs.spring.capstoneproject.service.InstrumentsService;



@CrossOrigin
@RestController
@RequestMapping("/instruments")
public class InstrumentsController {
	@Autowired
    private InstrumentsService service;
    @GetMapping("/{id}")
    public ResponseEntity<Object> getMessage(@PathVariable String id) {
        try {
            Instruments m=this.service.findById(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(m);
        }
        catch (EntityNotFoundException e) {
            System.out.println("error");
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("message not found");
        }
    }
    @GetMapping
    public List<Instruments> getInstruments(){
        return this.service.getInstruments();
    }
	

}
