package com.bridgelabz.workshop.iplproblem;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

import com.google.gson.Gson;

public class IplLeague {
	public static final String IPL_BATTINGCV_FILE_PATH = "C:\\Users\\abhis\\eclipse-workspace\\workshop.iplproblem\\resource\\IPL2019FactsheetMostRuns.csv";
	private static List<IplBattingCsv> batsmanList = null;

	public int loadIplBattingData(String csvFilePath) throws IplAnalyserException {
		try (Reader reader = Files.newBufferedReader(Paths.get(IPL_BATTINGCV_FILE_PATH))) {
			batsmanList = new OpenCSVBuilder().getCSVFileList(reader, IplBattingCsv.class);
			return batsmanList.size();
		} catch (IOException e) {
			throw new IplAnalyserException(e.getMessage(), IplAnalyserException.ExceptionType.IPL_FILE_PROBLEM);
		}
	}

	private <E> void sort(List<E> batsmanList, Comparator<E> comparator) {
		for (int i = 0; i < batsmanList.size() - 1; i++) {
			for (int j = 0; j < batsmanList.size() - i - 1; j++) {
				E census1 = batsmanList.get(i);
				E census2 = batsmanList.get(j + 1);
				if (comparator.compare(census1, census2) > 0) {
					batsmanList.set(i, census2);
					batsmanList.set(j + 1, census1);
				}
			}
		}
	}

	private <E> void sortdesc(List<E> batsmanList, Comparator<E> comparator) {
		for (int i = 0; i < batsmanList.size() - 1; i++) {
			for (int j = 0; j < batsmanList.size() - i - 1; j++) {
				E census1 = batsmanList.get(i);
				E census2 = batsmanList.get(j + 1);
				if (comparator.compare(census1, census2) < 0) {
					batsmanList.set(i, census2);
					batsmanList.set(j + 1, census1);
				}
			}
		}
	}

	public String sortPlayerOnAverage() throws IplAnalyserException {
		if (batsmanList == null || batsmanList.size() == 0)
			throw new IplAnalyserException("No Batsman Data", IplAnalyserException.ExceptionType.IPL_FILE_PROBLEM);
		Comparator<IplBattingCsv> comparator = Comparator.comparing(census -> census.average);
		this.sortdesc(batsmanList, comparator);
		String sortedAverageBatsman = new Gson().toJson(batsmanList);
		return sortedAverageBatsman;
	}

	public String sortPlayerOnStrikeRate() throws IplAnalyserException {
		if (batsmanList == null || batsmanList.size() == 0)
			throw new IplAnalyserException("No Batsman Data", IplAnalyserException.ExceptionType.IPL_FILE_PROBLEM);
		Comparator<IplBattingCsv> comparator = Comparator.comparing(census -> census.strikeRate);
		this.sortdesc(batsmanList, comparator);
		String sortedAverageBatsman = new Gson().toJson(batsmanList);
		return sortedAverageBatsman;
	}

}
