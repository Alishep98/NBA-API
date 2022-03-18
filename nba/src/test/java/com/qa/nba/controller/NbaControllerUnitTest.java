package com.qa.nba.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.qa.nba.entity.nba;
import com.qa.nba.service.NbaService;

@SpringBootTest
public class NbaControllerUnitTest {

	@Autowired
	private NbaController controller;
	
	@MockBean
	private NbaService service;
	
	@Test
	public void createnbaTest() {
		nba nba = new nba(1L, 34, "Stephen Curry", 26, 5, 6);
		
		Mockito.when(this.service.create(nba)).thenReturn(nba);
		
		ResponseEntity<nba> response = new ResponseEntity<nba>(nba, HttpStatus.CREATED);
		
		assertThat(response).isEqualTo(this.controller.createNba(nba));
		
		Mockito.verify(this.service, times(1)).create(nba);
	}
}