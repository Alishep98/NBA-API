package com.qa.nba.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.nba.entity.nba;
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc 

@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = { "classpath:nba-schema.sql",
		"classpath:nba-data.sql" })
public class NbaControllerIntegrationTest {

	@Autowired 
	private MockMvc mvc; 

	@Autowired
	private ObjectMapper mapper; 

	@Test
	public void test() {
		assertEquals(2, 1 + 1);
	}

	@Test
	public void testCreate() throws Exception {
		nba testnba = new nba(2, 28, "Joel Embiid", 30, 11, 4);
		String testnbaAsJSON = this.mapper.writeValueAsString(testnba);
		RequestBuilder req = post("/nba/create").content(testnbaAsJSON).contentType(MediaType.APPLICATION_JSON);

		nba testSavednba = new nba(2, 28, "Joel Embiid", 30, 11, 4);
		String testSavednbaAsJSON = this.mapper.writeValueAsString(testSavednba);
		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkBody = content().json(testSavednbaAsJSON);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	public void testCreate2() throws Exception {
		nba testnba = new nba(2, 32, "James Harden", 23, 8, 10);
		String testnbaAsJSON = this.mapper.writeValueAsString(testnba);
		RequestBuilder req = post("/nba/create").content(testnbaAsJSON).contentType(MediaType.APPLICATION_JSON);

		nba testSavedNba = new nba(2, 32, "James Harden", 23, 8, 10);
		String testSavedNbaAsJSON = this.mapper.writeValueAsString(testSavedNba);
		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkBody = content().json(testSavedNbaAsJSON);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	public void testReadById() throws Exception {
		RequestBuilder req = get("/nba/readById/1");

		ResultMatcher checkStatus = status().isOk();

		nba savednba = new nba(1, 34, "Stephen Curry", 26, 5, 6);
		String savednbaAsJSON = this.mapper.writeValueAsString(savednba);

		ResultMatcher checkBody = content().json(savednbaAsJSON);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	public void testReadAll() throws Exception {
		nba entry = new nba(1, 34, "Stephen Curry", 26, 5, 6);
		List<nba> nba = new ArrayList<>();
		nba.add(entry);
		String NbaOutputAsJson = this.mapper.writeValueAsString(nba);
		
		this.mvc.perform(get("/nba/readAll")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(NbaOutputAsJson));
	}
	
	@Test
	public void updateTest() throws Exception{
		nba entry = new nba(1, 34, "Stephen Curry", 26, 5, 6);
		String entrynbaAsJson = this.mapper.writeValueAsString(entry);
		
		nba result = new nba(1, 34, "Stephen Curry", 26, 5, 6);
		String resultNbaAsJson = this.mapper.writeValueAsString(result);
		
		this.mvc.perform(put("/nba/update/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(entrynbaAsJson))
		.andExpect(status().isAccepted())
		.andExpect(content().json(resultNbaAsJson));
	}
	
	
	
}