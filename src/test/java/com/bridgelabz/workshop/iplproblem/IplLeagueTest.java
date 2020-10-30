package com.bridgelabz.workshop.iplproblem;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;

public class IplLeagueTest {
	public static final String IPL_BATTINGCV_FILE_PATH = "C:\\Users\\abhis\\eclipse-workspace\\workshop.iplproblem\\resource\\IPL2019FactsheetMostRuns.csv";
	public static final String IPL_BOWLING_CSVFILE_PATH = "C:\\Users\\abhis\\eclipse-workspace\\workshop.iplproblem\\resource\\IPL2019FactsheetMostWkts.csv";
    
	/**
	 * uc13
	 * 
	 */
	@Test
	public void givenIplData_WhenSortedOnBestBattingAndBowlingAverage_ShouldReturnSortedResult() {
		try {
			IplLeague iplAnalyser = new IplLeague();
			iplAnalyser.loadIplBattingData(IPL_BATTINGCV_FILE_PATH);
			String sortedCensusData = iplAnalyser.sortPlayerOnAverage();
			IplBattingCsv[] sortedBatsmaAverageList = new Gson().fromJson(sortedCensusData, IplBattingCsv[].class);
			iplAnalyser.loadIplBowlingData(IPL_BOWLING_CSVFILE_PATH);
			String sortedData = iplAnalyser.sortBowlerPlayerOnAverage();
			IplBowlingCsv[] sortedBowlerAverageList = new Gson().fromJson(sortedData, IplBowlingCsv[].class);
			Assert.assertEquals(166.0f, sortedBowlerAverageList[0].getAverage(), 0.0);
			Assert.assertEquals(83.2f, sortedBatsmaAverageList[0].getAverage(), 0.0);

		} catch (IplAnalyserException e) {
			Assert.assertEquals(IplAnalyserException.ExceptionType.IPL_FILE_PROBLEM, e.type);
		}
	}
	
	@Test
	public void givenIplBowlingPlayerData_WhenSortedOnWicketWithAverage_ShouldReturnSortedResult() {
		try {
			IplLeague iplAnalyser = new IplLeague();
			iplAnalyser.loadIplBowlingData(IPL_BOWLING_CSVFILE_PATH);
			String sortedCensusData = iplAnalyser.sortBowlerPlayerOnWicketWithAverage();
			IplBowlingCsv[] sortedList = new Gson().fromJson(sortedCensusData, IplBowlingCsv[].class);
			Assert.assertEquals("Imran Tahir", sortedList[98].getPlayerName());

		} catch (IplAnalyserException e) {
			Assert.assertEquals(IplAnalyserException.ExceptionType.IPL_FILE_PROBLEM, e.type);
		}
	}

	@Test
	public void givenIplBowlingPlayerData_WhenSortedOnBowlingAverageWithBestStrikeRate_ShouldReturnSortedResult() {
		try {
			IplLeague iplAnalyser = new IplLeague();
			iplAnalyser.loadIplBowlingData(IPL_BOWLING_CSVFILE_PATH);
			String sortedCensusData = iplAnalyser.sortBowlerPlayerOnBowlingAverageWithBestStrikeRate();
			IplBowlingCsv[] sortedList = new Gson().fromJson(sortedCensusData, IplBowlingCsv[].class);
			Assert.assertEquals("Krishnappa Gowtham", sortedList[98].getPlayerName());

		} catch (IplAnalyserException e) {
			Assert.assertEquals(IplAnalyserException.ExceptionType.IPL_FILE_PROBLEM, e.type);
		}
	}

	@Test
	public void givenIplBowlingPlayerData_WhenSortedOnBestStrikeRateWith5w_ShouldReturnSortedResult() {
		try {
			IplLeague iplAnalyser = new IplLeague();
			iplAnalyser.loadIplBowlingData(IPL_BOWLING_CSVFILE_PATH);
			String sortedCensusData = iplAnalyser.sortBowlerPlayerOnStrikeRateWith5w();
			IplBowlingCsv[] sortedList = new Gson().fromJson(sortedCensusData, IplBowlingCsv[].class);

			Assert.assertEquals("Krishnappa Gowtham", sortedList[98].getPlayerName());
		} catch (IplAnalyserException e) {
			Assert.assertEquals(IplAnalyserException.ExceptionType.IPL_FILE_PROBLEM, e.type);
		}
	}

	@Test
	public void givenIplBowlingPlayerData_WhenSortedOnEconomy_ShouldReturnSortedResult() {
		try {
			IplLeague iplAnalyser = new IplLeague();
			iplAnalyser.loadIplBowlingData(IPL_BOWLING_CSVFILE_PATH);
			String sortedCensusData = iplAnalyser.sortBowlerPlayerOnEconomy();
			IplBowlingCsv[] sortedList = new Gson().fromJson(sortedCensusData, IplBowlingCsv[].class);

			Assert.assertEquals(4.8f, sortedList[0].getEconomy(), 0.0);
		} catch (IplAnalyserException e) {
			Assert.assertEquals(IplAnalyserException.ExceptionType.IPL_FILE_PROBLEM, e.type);
		}
	}

	@Test
	public void givenIplBowlingPlayerData_WhenSortedOnAverage_ShouldReturnSortedResult() {
		try {
			IplLeague iplAnalyser = new IplLeague();
			iplAnalyser.loadIplBowlingData(IPL_BOWLING_CSVFILE_PATH);
			String sortedCensusData = iplAnalyser.sortBowlerPlayerOnAverage();
			IplBowlingCsv[] sortedAverageList = new Gson().fromJson(sortedCensusData, IplBowlingCsv[].class);
			Assert.assertEquals(166.0f, sortedAverageList[0].getAverage(), 0.0);
		} catch (IplAnalyserException e) {
			Assert.assertEquals(IplAnalyserException.ExceptionType.IPL_FILE_PROBLEM, e.type);
		}
	}

	@Test
	public void givenIplBowlingPlayerData_WhenSortedOnStrike_ShouldReturnSortedResult() {
		try {
			IplLeague iplAnalyser = new IplLeague();
			iplAnalyser.loadIplBowlingData(IPL_BOWLING_CSVFILE_PATH);
			String sortedCensusData = iplAnalyser.sortBowlerPlayerOnStrikeRate();
			IplBowlingCsv[] sortedAverageList = new Gson().fromJson(sortedCensusData, IplBowlingCsv[].class);
			Assert.assertEquals(120f, sortedAverageList[0].getStrikeRate(), 0.0);
		} catch (IplAnalyserException e) {
			Assert.assertEquals(IplAnalyserException.ExceptionType.IPL_FILE_PROBLEM, e.type);
		}
	}

	@Test
	public void givenIplBatsmanPlayerData_WhenSortedOnAverage_ShouldReturnSortedResult() {
		try {
			IplLeague iplAnalyser = new IplLeague();
			iplAnalyser.loadIplBattingData(IPL_BATTINGCV_FILE_PATH);
			String sortedCensusData = iplAnalyser.sortPlayerOnAverage();
			IplBattingCsv[] sortedAverageList = new Gson().fromJson(sortedCensusData, IplBattingCsv[].class);
			Assert.assertEquals(83.2f, sortedAverageList[0].average, 0.0);
		} catch (IplAnalyserException e) {
			Assert.assertEquals(IplAnalyserException.ExceptionType.IPL_FILE_PROBLEM, e.type);
		}
	}

	@Test
	public void givenIplBatsmanPlayerData_WhenSortedOnStrikeRate_ShouldReturnSortedResult() {
		try {
			IplLeague iplAnalyser = new IplLeague();
			iplAnalyser.loadIplBattingData(IPL_BATTINGCV_FILE_PATH);
			String sortedCensusData = iplAnalyser.sortPlayerOnStrikeRate();
			IplBattingCsv[] sortedAverageList = new Gson().fromJson(sortedCensusData, IplBattingCsv[].class);
			Assert.assertEquals(333.33f, sortedAverageList[0].getStrikeRate(), 0.0);
		} catch (IplAnalyserException e) {
			Assert.assertEquals(IplAnalyserException.ExceptionType.IPL_FILE_PROBLEM, e.type);
		}
	}

	@Test
	public void givenIplBatsmanPlayerData_WhenSortedOn6s_ShouldReturnSortedResult() {
		try {
			IplLeague iplAnalyser = new IplLeague();
			iplAnalyser.loadIplBattingData(IPL_BATTINGCV_FILE_PATH);
			String sortedCensusData = iplAnalyser.sortPlayerOn6s();
			IplBattingCsv[] sortedAverageList = new Gson().fromJson(sortedCensusData, IplBattingCsv[].class);
			Assert.assertEquals("Andre Russell", sortedAverageList[0].getPlayerName());
		} catch (IplAnalyserException e) {
			Assert.assertEquals(IplAnalyserException.ExceptionType.IPL_FILE_PROBLEM, e.type);
		}
	}

	@Test
	public void givenIplBatsmanPlayerData_WhenSortedOn4s_ShouldReturnSortedResult() {
		try {
			IplLeague iplAnalyser = new IplLeague();
			iplAnalyser.loadIplBattingData(IPL_BATTINGCV_FILE_PATH);
			String sortedCensusData = iplAnalyser.sortPlayerOn4s();
			IplBattingCsv[] sortedAverageList = new Gson().fromJson(sortedCensusData, IplBattingCsv[].class);
			Assert.assertEquals("Shikhar Dhawan", sortedAverageList[0].getPlayerName());
		} catch (IplAnalyserException e) {
			Assert.assertEquals(IplAnalyserException.ExceptionType.IPL_FILE_PROBLEM, e.type);
		}
	}

	@Test
	public void givenIplBatsmanPlayerData_WhenSortedOnBestStrikeRateWith6s_ShouldReturnSortedResult() {
		try {
			IplLeague iplAnalyser = new IplLeague();
			iplAnalyser.loadIplBattingData(IPL_BATTINGCV_FILE_PATH);
			String sortedCensusData = iplAnalyser.sortPlayerOnBestStrikeRateWith6s();
			IplBattingCsv[] sortedAverageList = new Gson().fromJson(sortedCensusData, IplBattingCsv[].class);
			Assert.assertEquals("Ishant Sharma", sortedAverageList[100].getPlayerName());

		} catch (IplAnalyserException e) {
			Assert.assertEquals(IplAnalyserException.ExceptionType.IPL_FILE_PROBLEM, e.type);
		}
	}

	@Test
	public void givenIplBatsmanPlayerData_WhenSortedOnBestAverageRateWithStrikeRate_ShouldReturnSortedResult() {
		try {
			IplLeague iplAnalyser = new IplLeague();
			iplAnalyser.loadIplBattingData(IPL_BATTINGCV_FILE_PATH);
			String sortedCensusData = iplAnalyser.sortPlayerOnBestAverageRateWithStrikeRate();
			IplBattingCsv[] sortedList = new Gson().fromJson(sortedCensusData, IplBattingCsv[].class);
			Assert.assertEquals("MS Dhoni", sortedList[100].getPlayerName());

		} catch (IplAnalyserException e) {
			Assert.assertEquals(IplAnalyserException.ExceptionType.IPL_FILE_PROBLEM, e.type);
		}
	}

	@Test
	public void givenIplBatsmanPlayerData_WhenSortedOnMaximumRunWithBestAverage_ShouldReturnSortedResult() {
		try {
			IplLeague iplAnalyser = new IplLeague();
			iplAnalyser.loadIplBattingData(IPL_BATTINGCV_FILE_PATH);
			String sortedCensusData = iplAnalyser.sortPlayerMaximumRunWithBestAverage();
			IplBattingCsv[] sortedList = new Gson().fromJson(sortedCensusData, IplBattingCsv[].class);
			String playername = sortedList[100].getPlayerName();
			Assert.assertEquals("David Warner ", playername);

		} catch (IplAnalyserException e) {
			Assert.assertEquals(IplAnalyserException.ExceptionType.IPL_FILE_PROBLEM, e.type);
		}
	}

}
