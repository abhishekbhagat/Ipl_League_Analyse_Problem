package com.bridgelabz.workshop.iplproblem;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;

public class IplLeagueTest {
	public static final String IPL_BATTINGCV_FILE_PATH = "C:\\Users\\abhis\\eclipse-workspace\\workshop.iplproblem\\resource\\IPL2019FactsheetMostRuns";
	public static final String IPL_BOWLING_CSVFILE_PATH = "C:\\Users\\abhis\\eclipse-workspace\\workshop.iplproblem\\resource\\IPL2019FactsheetMostWkts";

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
			System.out.println(sortedAverageList[0].getPlayerName());
			Assert.assertEquals("Shikhar Dhawan", sortedAverageList[0].getPlayerName());
		} catch (IplAnalyserException e) {
			Assert.assertEquals(IplAnalyserException.ExceptionType.IPL_FILE_PROBLEM, e.type);
		}
	}
}
