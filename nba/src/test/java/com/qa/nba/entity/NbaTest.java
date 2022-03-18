package com.qa.nba.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class NbaTest {

	@Test
	public void testEquals() {
		EqualsVerifier.forClass(nba.class).usingGetClass().verify();
	}

	@Test
	public void getAndSetTest() {
		nba nba = new nba();

		nba.setId(1L);
		nba.setAge(28);
		nba.setPpg(30);
		nba.setRpg(11);
		nba.setApg(4);
		nba.setName("Joel Embiid");

		assertNotNull(nba.getAge());
		assertNotNull(nba.getId());
		assertNotNull(nba.getPpg());
		assertNotNull(nba.getRpg());
		assertNotNull(nba.getApg());
		assertNotNull(nba.getName());


		assertEquals(nba.getAge(), 28);
		assertEquals(nba.getId(), 1L);
		assertEquals(nba.getPpg(), 30);
		assertEquals(nba.getRpg(), 11);
		assertEquals(nba.getApg(), 4);
		assertEquals(nba.getName(), "Joel Embiid");
		
	}

	@Test
	public void allArgsConstructor() {
		nba nba = new nba(1L, 34, "Stephen Curry", 26, 5, 6);

		assertNotNull(nba.getAge());
		assertNotNull(nba.getId());
		assertNotNull(nba.getPpg());
		assertNotNull(nba.getRpg());
		assertNotNull(nba.getApg());
		assertNotNull(nba.getName());


		assertEquals(nba.getAge(), 34);
		assertEquals(nba.getId(), 1L);
		assertEquals(nba.getPpg(), 26);
		assertEquals(nba.getRpg(), 5);
		assertEquals(nba.getApg(), 6);
		assertEquals(nba.getName(), "Stephen Curry");
	}
}