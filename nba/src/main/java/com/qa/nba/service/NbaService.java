package com.qa.nba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.nba.entity.nba;
import com.qa.nba.repo.NbaRepo;

@Service
public class NbaService implements ServiceMethods<nba>{
	private NbaRepo repo;
	
	
	public NbaService(NbaRepo repo) {
		this.repo = repo;
	}

	@Override
	public nba create(nba nba) {
		return this.repo.save(nba);
	}

	@Override
	public List<nba> readAll() {
		return this.repo.findAll();
	}

	@Override
	public nba readById(long id) {
		Optional<nba> getNba = this.repo.findById(id);
		if(getNba.isPresent()) {
			return getNba.get();
		}
		return null;
	}

	@Override
	public nba update(long id, nba nba) {
		Optional<nba> existingNba = this.repo.findById(id);
		if(existingNba.isPresent()) {
			nba exists = existingNba.get();
			exists.setAge(nba.getAge());
			exists.setPpg(nba.getPpg());
			exists.setRpg(nba.getRpg());
			exists.setApg(nba.getApg());
			exists.setName(nba.getName());
			
			return this.repo.saveAndFlush(exists);
		}
		return null;
	}

	@Override
	public boolean delete(long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}