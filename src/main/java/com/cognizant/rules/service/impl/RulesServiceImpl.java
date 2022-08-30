package com.cognizant.rules.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.rules.client.AuthClient;
import com.cognizant.rules.exceptions.InvalidAccessException;
import com.cognizant.rules.model.RuleStatus;
import com.cognizant.rules.service.RulesService;

@Service
public class RulesServiceImpl implements RulesService {
	
	@Autowired
	AuthClient authClient;

	@Override
	public RuleStatus evaluateMinBalance(String token,String accountType,double balance) throws InvalidAccessException {
		if(authClient.validatingToken(token).isValidStatus()) {			
			if(accountType.equalsIgnoreCase("SAVINGS") && balance >= 400) {			
				return new RuleStatus("Allowed");
			} else if(accountType.equalsIgnoreCase("CURRENT") && balance >= 1000) {			
				return new RuleStatus("Allowed");
			} else if(accountType.equalsIgnoreCase("ZERO BALANCE") && balance >= 0) {			
				return new RuleStatus("Allowed");
			}
			return new RuleStatus("Denied");
		}
		throw new InvalidAccessException();
	}
	
	@Override
	public double getServiceCharges(String accountType){
			if(accountType.equalsIgnoreCase("SAVINGS")) {			
				return 0.1;
			} else if(accountType.equalsIgnoreCase("CURRENT")) {			
				return 0.05;
			} else if(accountType.equalsIgnoreCase("ZERO BALANCE")) {			
				return 0.2;
			}
			return 0;
	}
	

}
