package com.projectworld.ProjectWorld.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.projectworld.ProjectWorld.enums.CricketMatchStatus;

@Entity
@Table(name = "cricket_matches")
public class CricketMatch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "match_id")
	private long id;

	private String teamHeading;
	private String matchNumberVenue;
	private String battingTeam;
	private String battingTeamScore;
	private String bowlTeam;
	private String bowlTeamScore;
	private String liveText;
	private String matchLink;
	private String textComplete;

	@Enumerated
	private CricketMatchStatus status;
	private Date date = new Date();

	public CricketMatch() {
		super();
	}

	public CricketMatch(String teamHeading, String matchNumberVenue, String battingTeam, String battingTeamScore,
			String bowlTeam, String bowlTeamScore, String liveText, String matchLink, String textComplete,
			CricketMatchStatus status, Date date) {
		super();
		this.teamHeading = teamHeading;
		this.matchNumberVenue = matchNumberVenue;
		this.battingTeam = battingTeam;
		this.battingTeamScore = battingTeamScore;
		this.bowlTeam = bowlTeam;
		this.bowlTeamScore = bowlTeamScore;
		this.liveText = liveText;
		this.matchLink = matchLink;
		this.textComplete = textComplete;
		this.status = status;
		this.date = date;
	}

	@Override
	public String toString() {
		return "CricketMatch [id=" + id + ", teamHeading=" + teamHeading + ", matchNumberVenue=" + matchNumberVenue
				+ ", battingTeam=" + battingTeam + ", battingTeamScore=" + battingTeamScore + ", bowlTeam=" + bowlTeam
				+ ", bowlTeamScore=" + bowlTeamScore + ", liveText=" + liveText + ", matchLink=" + matchLink
				+ ", textComplete=" + textComplete + ", status=" + status + ", date=" + date + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTeamHeading() {
		return teamHeading;
	}

	public void setTeamHeading(String teamHeading) {
		this.teamHeading = teamHeading;
	}

	public String getMatchNumberVenue() {
		return matchNumberVenue;
	}

	public void setMatchNumberVenue(String matchNumberVenue) {
		this.matchNumberVenue = matchNumberVenue;
	}

	public String getBattingTeam() {
		return battingTeam;
	}

	public void setBattingTeam(String battingTeam) {
		this.battingTeam = battingTeam;
	}

	public String getBattingTeamScore() {
		return battingTeamScore;
	}

	public void setBattingTeamScore(String battingTeamScore) {
		this.battingTeamScore = battingTeamScore;
	}

	public String getBowlTeam() {
		return bowlTeam;
	}

	public void setBowlTeam(String bowlTeam) {
		this.bowlTeam = bowlTeam;
	}

	public String getBowlTeamScore() {
		return bowlTeamScore;
	}

	public void setBowlTeamScore(String bowlTeamScore) {
		this.bowlTeamScore = bowlTeamScore;
	}

	public String getLiveText() {
		return liveText;
	}

	public void setLiveText(String liveText) {
		this.liveText = liveText;
	}

	public String getMatchLink() {
		return matchLink;
	}

	public void setMatchLink(String matchLink) {
		this.matchLink = matchLink;
	}

	public String getTextComplete() {
		return textComplete;
	}

	public void setTextComplete(String textComplete) {
		this.textComplete = textComplete;
	}

	public CricketMatchStatus getStatus() {
		return status;
	}

	// set MatchStatus based on textComplete
	public void setStatus() {
		if (textComplete.isBlank()) {
			this.status = CricketMatchStatus.LIVE;
		} else {
			this.status = CricketMatchStatus.COMPLETED;
		}
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
