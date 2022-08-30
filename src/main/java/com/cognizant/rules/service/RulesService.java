package com.cognizant.rules.service;

import org.springframework.stereotype.Service;

import com.cognizant.rules.exceptions.InvalidAccessException;
import com.cognizant.rules.model.RuleStatus;

@Service
public interface RulesService {

	RuleStatus evaluateMinBalance(String token, String accountType, double balance) throws InvalidAccessException;

	double getServiceCharges(String accountType);
	
	
}
