package com.qa.nba.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.nba.entity.nba;

@Repository
public interface NbaRepo extends JpaRepository<nba, Long>{

}