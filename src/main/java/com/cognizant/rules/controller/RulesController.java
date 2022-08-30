package com.cognizant.rules.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.rules.exceptions.InvalidAccessException;
import com.cognizant.rules.service.RulesService;

import feign.FeignException.FeignClientException;

@RestController
public class RulesController {
	
	@Autowired
	RulesService rulesService;

	@CrossOrigin(origins ="http://localhost:5000")
	@GetMapping("/evaluate-min-balance/{balance}/{accountType}")
	public ResponseEntity<?> evaluateMinBalance(@RequestHeader(name="Authorization") String token,@PathVariable double balance, @PathVariable String accountType) {
		try {
			return new ResponseEntity<>(rulesService.evaluateMinBalance(token,accountType, balance),HttpStatus.OK);
		} catch (InvalidAccessException e) {
			return new ResponseEntity<>("UNAUTHORIZED_ACCESS",HttpStatus.UNAUTHORIZED);			
		} catch(FeignClientException e) {
			String[] message = e.getMessage().split(" ");
			int errCode = Integer.parseInt(message[0].split("")[1]+message[0].split("")[2]+message[0].split("")[3]);
			return new ResponseEntity<>(message[5],HttpStatus.valueOf(errCode));
		}
	}
	
	@CrossOrigin(origins ="http://localhost:5000")
	@GetMapping("/get-service-charges/{accountType}")
	public ResponseEntity<?> getServiceCharges(@PathVariable String accountType){
		return new ResponseEntity<>(rulesService.getServiceCharges(accountType),HttpStatus.OK);
	}

}
