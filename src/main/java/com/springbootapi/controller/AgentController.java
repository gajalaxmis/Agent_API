package com.springbootapi.controller;
import java.util.NoSuchElementException;

import org.apache.catalina.valves.ErrorReportValve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springbootapi.model.Agent;
import com.springbootapi.service.AgentService;
import antlr.collections.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content ;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Schema ;





@RestController
@RequestMapping("/agent")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AgentController {
	@Autowired
      AgentService aservice;
      @PostMapping("/")
      @Operation(summary = "Create a new Record for an agent", responses = {
		        @ApiResponse(responseCode = "201", description = "Record created", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Agent.class))),
	        @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorReportValve.class)))
		    })
      
      public ResponseEntity<Agent> createAgent(@RequestBody Agent age) {
    	  Agent newage = aservice.createAgent(age);
    	  return ResponseEntity.status(HttpStatus.CREATED).body(newage);
    	  
      }
      @GetMapping("/")
      @Operation(summary="Get All records of an agent")
      public java.util.List<Agent> getAllAgent(){
    	  return aservice.getAllAge();
      }
      @GetMapping("/{id}")
      @Operation(summary = "Get an agent", description = "retrieve an agent by agentid" )
      @ApiResponses(value= {
	  	         @ApiResponse(responseCode = "200", description = "Successfully retrieved agent",
	  	                 content = @Content(mediaType = "application/json", schema = @Schema(implementation = Agent.class))),
	  	         @ApiResponse(responseCode = "404", description = "agent not found",
	  	                 content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorReportValve.class))),
	  	         @ApiResponse(responseCode = "401", description = "Authentication Failure",
	  	                 content = @Content(mediaType = "application/json", schema = @Schema(hidden = true)))
	  	 }) 
      public ResponseEntity<Object>  getAgentById(@PathVariable Long id) {
    	  try {
	        	Agent age= aservice.getAgentById(id);
	            return ResponseEntity.ok(age);
	        } catch (NoSuchElementException e) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Agent with the id " + id + "is  not found");
	        }
    		  //return aservice.getAgentById(id);
    		 
    	  }
    	  @PutMapping("/{id}")
    	  @Operation(summary = "Update agent", responses = {
  			    @ApiResponse(responseCode = "200", description = "Agent has been updated", content = @Content(mediaType = "application/json", schema = @Schema(implementation =Agent.class))),
	  			    @ApiResponse(responseCode = "404", description = "Agent  not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorReportValve.class)))
	  			})
    	  public ResponseEntity<Object>  updateAgent(@PathVariable Long id,@RequestBody Agent age) {
    		  try {
  	        	Agent age1= aservice.updateAgent(id, age);
  	            return ResponseEntity.ok(age1);
  	        } catch (NoSuchElementException e) {
  	        	return
  	        	ResponseEntity.status(HttpStatus.NOT_FOUND).body("Agent with agentid " + id + " is not found");
  	        }
    		 // return aservice.updateAgent(id,age);
    	  }
    	  @DeleteMapping("/{id}")
    	  @Operation(summary = "Delete agent by AgentID")
	  	 @ApiResponse(responseCode = "204", description = "Agent has beendeleted")
 	  	 @ApiResponse(responseCode = "404", description = "Agent is not found")

    	  public ResponseEntity<String> deleteAgent(@PathVariable Long id) {
    		  try {
    			  aservice.deleteAgent(id);
    			  return ResponseEntity.ok().body("Agent with agentid " + id + " is deleted");
    		  } catch (NoSuchElementException e)
    		  {
    		  }
    		  return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Agent with AgentID " + id + "is  not found");
    	  }
    	  
    	  
    	 
    	  	        
 }
    	  	 
    	  	 
    	  	