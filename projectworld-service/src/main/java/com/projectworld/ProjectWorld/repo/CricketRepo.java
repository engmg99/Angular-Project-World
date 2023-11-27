package com.projectworld.ProjectWorld.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectworld.ProjectWorld.entity.CricketMatch;

public interface CricketRepo extends JpaRepository<CricketMatch, Long>{
	// fetch match data based on teamName
	public Optional<CricketMatch> findByTeamHeading(String teamHeading);

}
