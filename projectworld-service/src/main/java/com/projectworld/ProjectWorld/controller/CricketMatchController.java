package com.projectworld.ProjectWorld.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectworld.ProjectWorld.entity.CricketMatch;
import com.projectworld.ProjectWorld.service.impl.CricketServiceImpl;

@RestController
@RequestMapping("/match")
public class CricketMatchController {

	@Autowired
	private CricketServiceImpl cricketService;

	@GetMapping("/")
	public ResponseEntity<List<CricketMatch>> getAllMatches() {
		List<CricketMatch> cricketMatchesList = cricketService.getAllCricketMatches();
		return ResponseEntity.ok(cricketMatchesList);
	}

	@GetMapping("/live")
	public ResponseEntity<List<CricketMatch>> getAllLiveMatches() {
		List<CricketMatch> cricketMatchesList = cricketService.getAllLiveMatches();
		return ResponseEntity.ok(cricketMatchesList);
	}

	@GetMapping("/point-table")
	public ResponseEntity<?> getCWC2023PointTable() {
		return new ResponseEntity<>(this.cricketService.getMatchPointTable(), HttpStatus.OK);
	}
}
