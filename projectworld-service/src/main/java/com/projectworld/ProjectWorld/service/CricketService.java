package com.projectworld.ProjectWorld.service;

import java.util.List;

import com.projectworld.ProjectWorld.entity.CricketMatch;

public interface CricketService {
	public List<CricketMatch> getAllCricketMatches();

	public List<CricketMatch> getAllLiveMatches();

	public List<List<String>> getMatchPointTable();
}
