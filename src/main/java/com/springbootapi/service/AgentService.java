package com.springbootapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.springbootapi.model.Agent;
import com.springbootapi.repository.AgentRepo;
@Service
public class AgentService {
@Autowired
private AgentRepo repo;

public Agent createAgent(Agent age) {
	 repo.save(age);
	 return age;
	
}
	public List<Agent>getAllAge(){
		return repo.findAll();
		
}
	public Agent getAgentById(Long id) {
		Agent age=repo.findById(id).get();
		return age;
	}
	public Agent updateAgent(Long id, Agent Age) {
		Agent existingage=repo.findById(id).get();
		if(existingage==null) {
			throw new RuntimeException("Agent is not found with the given id: "+ id);
			
		}
		existingage.setAgentid(Age.getAgentid());
		 existingage.setAgentname(Age.getAgentname());
		 existingage.setPolicytype(Age.getPolicytype());
		 existingage.setNumberofinsurer(Age.getNumberofinsurer());
	existingage.setAgentbranch(Age.getAgentbranch());
	return repo.save(existingage);
	}
	public String deleteById(Long id) {
		repo.deleteById(id);
		return "Agent Data with Id: "+id +"is deleted";
	}
	//public void deleteAgent(Long id) {
		// TODO Auto-generated method stub
	//public void deleteAgent(Long id) {
		// TODO Auto-generated method stub
		
	
	public void deleteAgent(Long id) {
		// TODO Auto-generated method stub
		
	}
		
	
	//public void deleteAgent(Long id) {
		// TODO Auto-generated method stub
		
	}


