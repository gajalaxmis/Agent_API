package com.springbootapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootapi.model.Agent;

public interface AgentRepo  extends JpaRepository<Agent,  Long>{

}
