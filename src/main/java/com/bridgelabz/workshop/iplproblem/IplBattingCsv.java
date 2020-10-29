package com.bridgelabz.workshop.iplproblem;
import com.opencsv.bean.CsvBindByName;
public class IplBattingCsv {
	@CsvBindByName(column = "POS")
	public int pos;
	@CsvBindByName(column = "PLAYER")
	public String playerName;
	@CsvBindByName(column = "Mat")
	public int mat;
	@CsvBindByName(column = "Inns")
	public int inns;
	@CsvBindByName(column = "NO")
	public int no;
	@CsvBindByName(column = "Runs")
	public int runs;
	@CsvBindByName(column = "HS")
	public String highestScore;
	@CsvBindByName(column = "Avg")
	public float average;
	@CsvBindByName(column = "BF")
	public int bf;
	@CsvBindByName(column = "SR")
	public float strikeRate ;
	@CsvBindByName(column = "100")
	public int hundred;
	@CsvBindByName(column = "50")
	public int fifty;
	@CsvBindByName(column = "4s")
	public int four;
	@CsvBindByName(column = "6s")
	public int six;
	public int getPos() {
		return pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getInns() {
		return inns;
	}
	public void setInns(int inns) {
		this.inns = inns;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getRuns() {
		return runs;
	}
	public void setRuns(int runs) {
		this.runs = runs;
	}
	public String getHighestScore() {
		return highestScore;
	}
	public void setHighestScore(String highestScore) {
		this.highestScore = highestScore;
	}
	public float getAverage() {
		return average;
	}
	public void setAverage(float average) {
		this.average = average;
	}
	public int getBf() {
		return bf;
	}
	public void setBf(int bf) {
		this.bf = bf;
	}
	public float getStrikeRate() {
		return strikeRate;
	}
	public void setStrikeRate(float strikeRate) {
		this.strikeRate = strikeRate;
	}
	public int getHundred() {
		return hundred;
	}
	public void setHundred(int hundred) {
		this.hundred = hundred;
	}
	public int getFifty() {
		return fifty;
	}
	public void setFifty(int fifty) {
		this.fifty = fifty;
	}
	public int getFour() {
		return four;
	}
	public void setFour(int four) {
		this.four = four;
	}
	public int getSix() {
		return six;
	}
	public void setSix(int six) {
		this.six = six;
	}
	@Override
	public String toString() {
		return "IplBattingCsv [pos=" + pos + ", playerName=" + playerName + ", mat=" + mat + ", inns=" + inns + ", no="
				+ no + ", runs=" + runs + ", highestScore=" + highestScore + ", average=" + average + ", bf=" + bf
				+ ", strikeRate=" + strikeRate + ", hundred=" + hundred + ", fifty=" + fifty + ", four=" + four
				+ ", six=" + six + "]";
	} 
}
