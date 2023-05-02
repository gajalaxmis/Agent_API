package com.springbootapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.ResponseStatus;

import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.Data;

@Data
@Entity
@Table(name = "agent")
public class Agent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long agentid;
	private String agentname;
	private String policytype;
	private int numberofinsurer;
	private String agentbranch;
	public Long getAgentid() {
		return agentid;
	}
}
//	public void setAgentid(Long agentid) {
//		this.agentid = agentid;
//	}
//	public String getAgentname() {
//		return agentname;
//	}
//	public void setAgentname(String agentname) {
//		this.agentname = agentname;
//	}
//	public String getPolicytype() {
//		return policytype;
//	}
//	public void setPolicytype(String policytype) {
//		this.policytype = policytype;
//	}
//	public int getNumberofinsurer() {
//		return numberofinsurer;
//	}
//	public void setNumberofinsurer(int numberofinsurer) {
//		this.numberofinsurer = numberofinsurer;
//	}
//	public String getAgentbranch() {
//		return agentbranch;
//	}
//	public void setAgentbranch(String agentbranch) {
//		this.agentbranch = agentbranch;
//	}
//
//

