package com.dbs.spring.capstoneproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.spring.capstoneproject.model.Instruments;
import com.dbs.spring.capstoneproject.repository.InstrumentsRepository;


@Service
public class InstrumentsService {
	@Autowired
    private InstrumentsRepository repo;
    
    public Instruments findById(String id) {
        try {
            Optional<Instruments> instrument=this.repo.findById(id);
            return instrument.orElseThrow(()->{
                return new EntityNotFoundException("Instrument with "+id+" does not exist");
            });
        }
        catch(IllegalArgumentException iae) {
            return null;
        }
    }
    public List<Instruments> getInstruments(){
        List<Instruments> m=new ArrayList<>();
        this.repo.findAll().forEach(msg->m.add(msg));
        return m;
    }


}
