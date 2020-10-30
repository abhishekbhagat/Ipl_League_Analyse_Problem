package com.bridgelabz.workshop.iplproblem;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.gson.Gson;

public class IplLeague {
	private static List<IplBattingCsv> batsmanList = null;
	private static List<IplBowlingCsv> bowlingList = null;

	public int loadIplBowlingData(String csvFilePath) throws IplAnalyserException {
		try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
			bowlingList = new OpenCSVBuilder().getCSVFileList(reader, IplBowlingCsv.class);
			return bowlingList.size();
		} catch (IOException e) {
			throw new IplAnalyserException(e.getMessage(), IplAnalyserException.ExceptionType.IPL_FILE_PROBLEM);
		}
	}

	public int loadIplBattingData(String csvFilePath) throws IplAnalyserException {
		try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
			batsmanList = new OpenCSVBuilder().getCSVFileList(reader, IplBattingCsv.class);
			return batsmanList.size();
		} catch (IOException e) {
			throw new IplAnalyserException(e.getMessage(), IplAnalyserException.ExceptionType.IPL_FILE_PROBLEM);
		}
	}

	private <E> void sort(List<E> playerList, Comparator<E> comparator) {
		for (int i = 0; i < playerList.size() - 1; i++) {
			for (int j = 0; j < playerList.size() - i - 1; j++) {
				E census1 = playerList.get(i);
				E census2 = playerList.get(j + 1);
				if (comparator.compare(census1, census2) > 0) {
					playerList.set(i, census2);
					playerList.set(j + 1, census1);
				}
			}
		}
	}

	private <E> void sortdesc(List<E> playerList, Comparator<E> comparator) {
		for (int i = 0; i < playerList.size() - 1; i++) {
			for (int j = 0; j < playerList.size() - i - 1; j++) {
				E census1 = playerList.get(i);
				E census2 = playerList.get(j + 1);
				if (comparator.compare(census1, census2) < 0) {
					playerList.set(i, census2);
					playerList.set(j + 1, census1);
				}
			}
		}
	}

	/**
	 * uc12
	 * 
	 * @return
	 * @throws IplAnalyserException
	 */
	public String sortBowlerPlayerOnWicketWithAverage() throws IplAnalyserException {
		if (bowlingList == null || bowlingList.size() == 0)
			throw new IplAnalyserException("No Batsman Data", IplAnalyserException.ExceptionType.IPL_FILE_PROBLEM);
		Collections.sort(bowlingList, new SortingBowlerPlayerOnWicketWithAverageComparator());
		String sortedPlayer = new Gson().toJson(bowlingList);
		return sortedPlayer;
	}

	/**
	 * uc11
	 * 
	 * @return
	 * @throws IplAnalyserException
	 */
	public String sortBowlerPlayerOnBowlingAverageWithBestStrikeRate() throws IplAnalyserException {
		if (bowlingList == null || bowlingList.size() == 0)
			throw new IplAnalyserException("No Batsman Data", IplAnalyserException.ExceptionType.IPL_FILE_PROBLEM);
		Collections.sort(bowlingList, new SortingOnBowlingAverageWithBestStrikeRateComparator());
		String sortedPlayer = new Gson().toJson(bowlingList);
		return sortedPlayer;
	}

	/**
	 * uc10
	 * 
	 * @return
	 * @throws IplAnalyserException
	 */
	public String sortBowlerPlayerOnStrikeRateWith5w() throws IplAnalyserException {
		if (bowlingList == null || bowlingList.size() == 0)
			throw new IplAnalyserException("No Batsman Data", IplAnalyserException.ExceptionType.IPL_FILE_PROBLEM);
		Collections.sort(bowlingList, new SortingOnStrikeRateWith5wComparator());
		String sortedPlayer = new Gson().toJson(bowlingList);
		return sortedPlayer;
	}

	/**
	 * uc9
	 * 
	 * @return
	 * @throws IplAnalyserException
	 */
	public String sortBowlerPlayerOnEconomy() throws IplAnalyserException {
		if (bowlingList == null || bowlingList.size() == 0)
			throw new IplAnalyserException("No Bowler Data", IplAnalyserException.ExceptionType.IPL_FILE_PROBLEM);
		Comparator<IplBowlingCsv> comparator = Comparator.comparing(census -> census.economy);
		this.sort(bowlingList, comparator);
		String sorted = new Gson().toJson(bowlingList);
		return sorted;
	}

	/**
	 * uc8
	 * 
	 * @return
	 * @throws IplAnalyserException
	 */
	public String sortBowlerPlayerOnStrikeRate() throws IplAnalyserException {
		if (bowlingList == null || bowlingList.size() == 0)
			throw new IplAnalyserException("No Bowler Data", IplAnalyserException.ExceptionType.IPL_FILE_PROBLEM);
		Comparator<IplBowlingCsv> comparator = Comparator.comparing(census -> census.strikeRate);
		this.sortdesc(bowlingList, comparator);
		String sorted = new Gson().toJson(bowlingList);
		return sorted;
	}

	/**
	 * uc7
	 * 
	 * @return
	 * @throws IplAnalyserException
	 */
	public String sortBowlerPlayerOnAverage() throws IplAnalyserException {
		if (bowlingList == null || bowlingList.size() == 0)
			throw new IplAnalyserException("No Bowler Data", IplAnalyserException.ExceptionType.IPL_FILE_PROBLEM);
		Comparator<IplBowlingCsv> comparator = Comparator.comparing(census -> census.average);
		this.sortdesc(bowlingList, comparator);
		String sortedAverageBowler = new Gson().toJson(bowlingList);
		return sortedAverageBowler;
	}

	/**
	 * uc6
	 * 
	 * @return
	 * @throws IplAnalyserException
	 */
	public String sortPlayerMaximumRunWithBestAverage() throws IplAnalyserException {
		if (batsmanList == null || batsmanList.size() == 0)
			throw new IplAnalyserException("No Batsman Data", IplAnalyserException.ExceptionType.IPL_FILE_PROBLEM);
		Collections.sort(batsmanList, new SortingOnMaximumRunWithBestAverageComparator());
		String sortedPlayer = new Gson().toJson(batsmanList);
		return sortedPlayer;
	}

	/**
	 * uc5
	 * 
	 * @return
	 * @throws IplAnalyserException
	 */
	public String sortPlayerOnBestAverageRateWithStrikeRate() throws IplAnalyserException {
		if (batsmanList == null || batsmanList.size() == 0)
			throw new IplAnalyserException("No Batsman Data", IplAnalyserException.ExceptionType.IPL_FILE_PROBLEM);
		Collections.sort(batsmanList, new SortingOnBestAverageRateWithStrikeRateComparator());
		String sortedPlayer = new Gson().toJson(batsmanList);
		return sortedPlayer;
	}

	/**
	 * uc4
	 * 
	 * @return
	 * @throws IplAnalyserException
	 */
	public String sortPlayerOnBestStrikeRateWith6s() throws IplAnalyserException {
		if (batsmanList == null || batsmanList.size() == 0)
			throw new IplAnalyserException("No Batsman Data", IplAnalyserException.ExceptionType.IPL_FILE_PROBLEM);
		Collections.sort(batsmanList, new SortingOnBestStrikeRateWith6sComparator());
		String sortedPlayerOnStrikeRateWith6s = new Gson().toJson(batsmanList);
		return sortedPlayerOnStrikeRateWith6s;
	}

	/**
	 * uc3
	 * 
	 * @return
	 * @throws IplAnalyserException
	 */
	public String sortPlayerOn6s() throws IplAnalyserException {
		if (batsmanList == null || batsmanList.size() == 0)
			throw new IplAnalyserException("No Batsman Data", IplAnalyserException.ExceptionType.IPL_FILE_PROBLEM);
		Comparator<IplBattingCsv> comparator = Comparator.comparing(census -> census.six);
		this.sortdesc(batsmanList, comparator);
		String sorted6sBatsman = new Gson().toJson(batsmanList);
		return sorted6sBatsman;
	}

	public String sortPlayerOn4s() throws IplAnalyserException {
		if (batsmanList == null || batsmanList.size() == 0)
			throw new IplAnalyserException("No Batsman Data", IplAnalyserException.ExceptionType.IPL_FILE_PROBLEM);
		Comparator<IplBattingCsv> comparator = Comparator.comparing(census -> census.four);
		this.sortdesc(batsmanList, comparator);
		String sorted4sBatsman = new Gson().toJson(batsmanList);
		return sorted4sBatsman;
	}

	/**
	 * uc2
	 * 
	 * @return
	 * @throws IplAnalyserException
	 */
	public String sortPlayerOnStrikeRate() throws IplAnalyserException {
		if (batsmanList == null || batsmanList.size() == 0)
			throw new IplAnalyserException("No Batsman Data", IplAnalyserException.ExceptionType.IPL_FILE_PROBLEM);
		Comparator<IplBattingCsv> comparator = Comparator.comparing(census -> census.strikeRate);
		this.sortdesc(batsmanList, comparator);
		String sortedStrikeRateBatsman = new Gson().toJson(batsmanList);
		return sortedStrikeRateBatsman;
	}

	/**
	 * uc1
	 * 
	 * @return
	 * @throws IplAnalyserException
	 */
	public String sortPlayerOnAverage() throws IplAnalyserException {
		if (batsmanList == null || batsmanList.size() == 0)
			throw new IplAnalyserException("No Batsman Data", IplAnalyserException.ExceptionType.IPL_FILE_PROBLEM);
		Comparator<IplBattingCsv> comparator = Comparator.comparing(census -> census.average);
		this.sortdesc(batsmanList, comparator);
		String sortedAverageBatsman = new Gson().toJson(batsmanList);
		return sortedAverageBatsman;
	}

	public static class SortingBowlerPlayerOnWicketWithAverageComparator implements Comparator<IplBowlingCsv> {
		@Override
		public int compare(IplBowlingCsv player1, IplBowlingCsv player2) {
			int average = player1.getAverage().compareTo(player2.getAverage());
			int wicket = player1.getWicket().compareTo(player2.getWicket());

			// 2-level comparison using if-else block
			if (wicket == 0) {
				return ((average == 0) ? wicket : average);
			} else {
				return wicket;
			}
		}
	}

	public static class SortingOnBowlingAverageWithBestStrikeRateComparator implements Comparator<IplBowlingCsv> {
		@Override
		public int compare(IplBowlingCsv player1, IplBowlingCsv player2) {
			int average = player1.getAverage().compareTo(player2.getAverage());
			int strikeRate = player1.getStrikeRate().compareTo(player2.getStrikeRate());

			// 2-level comparison using if-else block
			if (average == 0) {
				return ((strikeRate == 0) ? average : strikeRate);
			} else {
				return average;
			}
		}
	}

	public static class SortingOnMaximumRunWithBestAverageComparator implements Comparator<IplBattingCsv> {
		@Override
		public int compare(IplBattingCsv player1, IplBattingCsv player2) {
			int maximumRun = player1.getRuns().compareTo(player2.getRuns());
			int averageCompare = player1.getAverage().compareTo(player2.getAverage());

			// 2-level comparison using if-else block
			if (maximumRun == 0) {
				return ((averageCompare == 0) ? maximumRun : averageCompare);
			} else {
				return maximumRun;
			}
		}
	}

	public static class SortingOnStrikeRateWith5wComparator implements Comparator<IplBowlingCsv> {
		@Override
		public int compare(IplBowlingCsv player1, IplBowlingCsv player2) {

			// for comparison
			int strikeRateCompare = player1.getStrikeRate().compareTo(player2.getStrikeRate());
			int fiveWicket = player1.getFivewicket().compareTo(player2.getFivewicket());

			// 2-level comparison using if-else block
			if (strikeRateCompare == 0) {
				return ((fiveWicket == 0) ? strikeRateCompare : fiveWicket);
			} else {
				return strikeRateCompare;
			}
		}
	}

	public static class SortingOnBestStrikeRateWith6sComparator implements Comparator<IplBattingCsv> {
		@Override
		public int compare(IplBattingCsv customer1, IplBattingCsv customer2) {

			// for comparison
			int strikeRateCompare = customer1.getStrikeRate().compareTo(customer2.getStrikeRate());
			int sixCompare = customer1.getSix().compareTo(customer2.getSix());

			// 2-level comparison using if-else block
			if (strikeRateCompare == 0) {
				return ((sixCompare == 0) ? strikeRateCompare : sixCompare);
			} else {
				return strikeRateCompare;
			}
		}
	}

	public static class SortingOnBestAverageRateWithStrikeRateComparator implements Comparator<IplBattingCsv> {
		@Override
		public int compare(IplBattingCsv customer1, IplBattingCsv customer2) {

			// for comparison
			int averageCompare = customer1.getAverage().compareTo(customer2.getAverage());
			int strikeRateCompare = customer1.getStrikeRate().compareTo(customer2.getStrikeRate());

			// 2-level comparison using if-else block
			if (averageCompare == 0) {
				return ((strikeRateCompare == 0) ? strikeRateCompare : strikeRateCompare);
			} else {
				return averageCompare;
			}
		}
	}

}
