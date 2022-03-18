package com.qa.nba.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.nba.entity.nba;
import com.qa.nba.repo.NbaRepo;

@SpringBootTest
public class NbaServiceTest {
	
	@Autowired
	private NbaService service;

	@MockBean
	private NbaRepo repo;

	@Test
	public void createNbaTest() {
		nba input = new nba(1L, 34, "Stephen Curry", 26, 5, 6);
		nba output = new nba(1L, 34, "Stephen Curry", 26, 5, 6);

		Mockito.when(this.repo.save(input)).thenReturn(output);

		assertEquals(output, this.service.create(input));
		
		Mockito.verify(this.repo, Mockito.times(1)).save(input);
	}
	
	@Test
	public void readByIdTest() {
		Optional<nba> optionalOutput = Optional.of(new nba(1L, 34, "Stephen Curry", 26, 5, 6));
		nba output = new nba(1L, 34, "Stephen Curry", 26, 5, 6);
		
		Mockito.when(this.repo.findById(Mockito.anyLong())).thenReturn(optionalOutput);
		
		assertEquals(output, this.service.readById(Mockito.anyLong()));
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(Mockito.anyLong());
	}
	
	
	@Test
	public void deleteTrueTest() {
		Mockito.when(this.repo.existsById(1L)).thenReturn(false);
		
		assertTrue(this.service.delete(1L));
		
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(1L);
		Mockito.verify(this.repo, Mockito.times(1)).existsById(1L);
	}
	
	
	
}