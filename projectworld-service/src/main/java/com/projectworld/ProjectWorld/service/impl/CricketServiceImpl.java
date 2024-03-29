package com.projectworld.ProjectWorld.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectworld.ProjectWorld.entity.CricketMatch;
import com.projectworld.ProjectWorld.repo.CricketRepo;
import com.projectworld.ProjectWorld.service.CricketService;

@Service
public class CricketServiceImpl implements CricketService {

	@Autowired
	private CricketRepo repo;

	@Override
	public List<CricketMatch> getAllCricketMatches() {
		return repo.findAll();
	}

	@Override
	public List<CricketMatch> getAllLiveMatches() {
		List<CricketMatch> matches = new ArrayList<>();
		try {
			String url = "https://www.cricbuzz.com/cricket-match/live-scores";
			Document document = Jsoup.connect(url).get();
			Elements liveScoreElements = document.select("div.cb-mtch-lst.cb-tms-itm");
			for (Element match : liveScoreElements) {
				String teamsHeading = match.select("h3.cb-lv-scr-mtch-hdr").select("a").text();
				String matchNumberVenue = match.select("span").text();
				Elements matchBatTeamInfo = match.select("div.cb-hmscg-bat-txt");
				String battingTeam = matchBatTeamInfo.select("div.cb-hmscg-tm-nm").text();
				String score = matchBatTeamInfo.select("div.cb-hmscg-tm-nm+div").text();
				Elements bowlTeamInfo = match.select("div.cb-hmscg-bwl-txt");
				String bowlTeam = bowlTeamInfo.select("div.cb-hmscg-tm-nm").text();
				String bowlTeamScore = bowlTeamInfo.select("div.cb-hmscg-tm-nm+div").text();
				String textLive = match.select("div.cb-text-live").text();
				String textComplete = match.select("div.cb-text-complete").text();
				// getting match link
				String matchLink = match.select("a.cb-lv-scrs-well.cb-lv-scrs-well-live").attr("href").toString();

				CricketMatch match1 = new CricketMatch();
				match1.setTeamHeading(teamsHeading);
				match1.setMatchNumberVenue(matchNumberVenue);
				match1.setBattingTeam(battingTeam);
				match1.setBattingTeamScore(score);
				match1.setBowlTeam(bowlTeam);
				match1.setBowlTeamScore(bowlTeamScore);
				match1.setLiveText(textLive);
				match1.setMatchLink(matchLink);
				match1.setTextComplete(textComplete);
				match1.setStatus();
				matches.add(match1);
				updateMatchInDB(match1);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return matches;
	}

	private void updateMatchInDB(CricketMatch match1) {
		CricketMatch match = repo.findByTeamHeading(match1.getTeamHeading()).orElse(null);
		if (match == null) {
			this.repo.save(match1);
		} else {
			match1.setId(match.getId());
			this.repo.save(match1);
		}
	}

	@Override
	public List<List<String>> getMatchPointTable() {
		List<List<String>> pointTable = new ArrayList<>();
		String tableURL = "https://www.cricbuzz.com/cricket-series/6732/icc-cricket-world-cup-2023/points-table";
		try {
			Document document = Jsoup.connect(tableURL).get();
			Elements table = document.select("table.cb-srs-pnts");
			Elements tableHeads = table.select("thead>tr>*");
			List<String> headers = new ArrayList<>();
			tableHeads.forEach(element -> {
				headers.add(element.text());
			});
			pointTable.add(headers);
			Elements bodyTrs = table.select("tbody>*");
			bodyTrs.forEach(tr -> {
				List<String> points = new ArrayList<>();
				if (tr.hasAttr("class")) {
					Elements tds = tr.select("td");
					String team = tds.get(0).select("div.cb-col-84").text();
					points.add(team);
					tds.forEach(td -> {
						if (!td.hasClass("cb-srs-pnts-name")) {
							points.add(td.text());
						}
					});
					pointTable.add(points);
				}

			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pointTable;
	}
}
