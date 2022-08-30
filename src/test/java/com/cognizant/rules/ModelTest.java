package com.cognizant.rules;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.rules.model.RuleStatus;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ModelTest {

	RuleStatus ruleStatus;
	
	@Test
	void testRuleStatusModel() {
		ruleStatus = new RuleStatus("DENIED");
		assertEquals("DENIED", ruleStatus.getStatus());
	}
	
}
