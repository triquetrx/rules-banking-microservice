package com.cognizant.rules;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.rules.service.RulesService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ServiceTest {
	
	
	RulesService rulesService;
	
	@Test
	void testServiceLoad() {
		assertThat(rulesService).isNull();
	}

}
