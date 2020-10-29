package com.bridgelabz.workshop.iplproblem;
import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;


public class IplLeagueTest {
   public static final String IPL_BATTINGCV_FILE_PATH="C:\\Users\\abhis\\eclipse-workspace\\workshop.iplproblem\\resource\\IPL2019FactsheetMostRuns";
   public static final String IPL_BOWLING_CSVFILE_PATH="C:\\Users\\abhis\\eclipse-workspace\\workshop.iplproblem\\resource\\IPL2019FactsheetMostWkts";
   @Test
	public void givenIplBatsmanPlayerData_WhenSortedOnAverage_ShouldReturnSortedResult(){
		try {
			IplLeague iplAnalyser = new IplLeague ();
			iplAnalyser.loadIplBattingData(IPL_BATTINGCV_FILE_PATH);
			String sortedCensusData = iplAnalyser.sortPlayerOnAverage();
			IplBattingCsv[] sortedAverageList = new Gson().fromJson(sortedCensusData, IplBattingCsv[].class);
			System.out.println(sortedAverageList[0].average);
			Assert.assertEquals(83.2f,sortedAverageList[0].average,0.0);
		} catch (IplAnalyserException e) {
			Assert.assertEquals(IplAnalyserException.ExceptionType.IPL_FILE_PROBLEM, e.type);
		}
	}
}
