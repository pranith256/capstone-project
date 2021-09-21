package com.dbs.spring.capstoneproject.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.spring.capstoneproject.model.Sell;
import com.dbs.spring.capstoneproject.model.Transaction;
import com.dbs.spring.capstoneproject.model.Buy;
import com.dbs.spring.capstoneproject.model.Client;
import com.dbs.spring.capstoneproject.model.Clientstocks;
import com.dbs.spring.capstoneproject.model.Sell;
import com.dbs.spring.capstoneproject.repository.BuyRepository;
import com.dbs.spring.capstoneproject.repository.ClientRepository;
import com.dbs.spring.capstoneproject.repository.ClientstocksRepository;
import com.dbs.spring.capstoneproject.repository.InstrumentsRepository;
import com.dbs.spring.capstoneproject.repository.SellRepository;
import com.dbs.spring.capstoneproject.repository.TransactionRepository;

@Service
public class SellService {
	public SellService()
	{}
	@Autowired
	private BuyRepository repo;
	@Autowired
	private ClientService cservice;
	@Autowired
	private ClientRepository crepo;
	@Autowired
	private InstrumentsRepository irepo;
	@Autowired
	private ClientstocksRepository csrepo;
	@Autowired
	private SellRepository srepo;
	@Autowired
	private TransactionRepository trepo;
	
	public List<Sell> findallbid()
	{
		List<Sell>  clients = new ArrayList<Sell>();
		this.srepo.findAll().forEach(tt->clients.add(tt));
		return clients;
	}
	
	public List<Sell> findsaleSellsbyid(String id)
	{
		List<Sell>  clients = new ArrayList<Sell>();
		this.srepo.findAllByClientClientid(id).forEach(tt->clients.add(tt));
		return clients;
	}
	public Sell findbyid(int sid){
		 try {
	            Optional<Sell> c=this.srepo.findById(sid);
	            return c.orElseThrow(()->{
	                return new EntityNotFoundException("Sid does not exist");
	            });
	            }
	        catch(IllegalArgumentException e) {
	        	System.out.println("Error: "+e.getMessage());
				return null;
	        }
	        }

	public int insertSell(String cid,String iid, int p, int q) {
		int sid=(int)this.srepo.count()+1;
		Client client = cservice.findclientid(cid);
		if(client.getTransactionlimit()<(p*q)) {
			return -1 ;
		}
		System.out.println(this.repo.count());
		Sell is=new Sell(sid,crepo.findById(cid).get(),irepo.findById(iid).get(),q,q,p,(LocalDateTime.now()),"pending");
		srepo.save(is);
		System.out.println(sid);
		List<Integer> l=this.srepo.sOrderMatching(iid, p);
		System.out.println(sid);
		Sell s=this.srepo.findById(sid).get();
		client.setTransactionlimit(client.getTransactionlimit()-(p*q));
		crepo.save(client);
		int quan=q;
		while(quan>0 && l.size()>0)
		{
			Buy b= this.repo.findById(l.get(0)).get();
			if(s.getRem_quantity()>=b.getRem_quantity())
			{
				s.setRem_quantity(s.getRem_quantity()-b.getRem_quantity());
				int sq=s.getRem_quantity();
				b.setRem_quantity(0);
				b.setStatus("completed");
				if(sq==0)
				{
					s.setStatus("completed");
				}
				this.insertClientStocks(s.getClient().getClientid(),s.getInstrument().getInstrumentid(),sq,'s');
				this.insertClientStocks(b.getClient().getClientid(), iid, quan, 'b');
				this.insertTransactionHistory(b.getBuyid(),sid,iid,p,quan);
				quan=0;
			}
			else
			{
				b.setRem_quantity(b.getRem_quantity()-s.getRem_quantity());
				int sq=s.getRem_quantity();
				quan=quan-sq;
				s.setRem_quantity(0);
				s.setStatus("completed");
				this.insertClientStocks(s.getClient().getClientid(), iid, sq, 's');
				this.insertClientStocks(b.getClient().getClientid(), iid, sq, 'b');
				this.insertTransactionHistory(b.getBuyid(),sid,iid,p,sq);	
			}
			repo.save(b);
			srepo.save(s);
			l.remove(0);
		}
		return sid;
		}
	public void insertClientStocks(String cid,String iid, int quantity,char type) {
		String ciid=cid+iid;
		if(csrepo.existsById(ciid))
		{
			Clientstocks cs=csrepo.findById(ciid).get();
			if(type=='s')
			{
				cs.setQuantity(cs.getQuantity()-quantity);
			}
			else
			{
				cs.setQuantity(cs.getQuantity()+quantity);
			}
		}
		else
		{
			Clientstocks cs=new Clientstocks(ciid,crepo.findById(cid).get(),irepo.findById(iid).get(),quantity,irepo.findById(iid).get().getInstrumentname());
			csrepo.save(cs);
		}
		
		
	}
	 
	public void insertTransactionHistory(int bid,int sid,String iid,int price,int quantity)
	{
		Transaction ts=new Transaction();
		ts.setBuyer(repo.findById(bid).get().getClient());
		ts.setSeller(srepo.findById(sid).get().getClient());
		ts.setInstrument(irepo.findById(iid).get());
		ts.setPrice(price);
		ts.setQuantity(quantity);
		ts.setDate(LocalDateTime.now());
		//ts.setCustodian(crepo.findById(repo.findById(bid).get().getClient().getClientid()).get().getCustodianid());
		ts.setBuy_custodian(crepo.findById(repo.findById(bid).get().getClient().getClientid()).get().getCustodianid());
		ts.setSell_custodian(crepo.findById(srepo.findById(sid).get().getClient().getClientid()).get().getCustodianid());
		trepo.save(ts);
	}
	

}
