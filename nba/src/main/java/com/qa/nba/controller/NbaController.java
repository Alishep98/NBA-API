package com.qa.nba.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.nba.entity.nba;
import com.qa.nba.service.NbaService;

@RestController
@RequestMapping("/nba")
public class NbaController {

	private NbaService service;
	
	private NbaController(NbaService service) {
		this.service = service;
	}
	
	@PostMapping("/create")
	public ResponseEntity<nba> createNba(@RequestBody nba nba){
		return new ResponseEntity<nba>(this.service.create(nba), HttpStatus.CREATED);
	}
	
	@GetMapping("/readAll")
	public ResponseEntity<List<nba>> readAllNba(){
		return new ResponseEntity<List<nba>>(this.service.readAll(), HttpStatus.OK);
	}
	
	
	@GetMapping("/readById/{id}")
	public ResponseEntity<nba> readById(@PathVariable long id){
		return new ResponseEntity<nba>(this.service.readById(id), HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<nba> updateNba(@PathVariable long id, @RequestBody nba nba){
		return new ResponseEntity<nba>(this.service.update(id, nba), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteNba(@PathVariable long id){
		return (this.service.delete(id)) ? new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT) : 
			new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
	}
	
}