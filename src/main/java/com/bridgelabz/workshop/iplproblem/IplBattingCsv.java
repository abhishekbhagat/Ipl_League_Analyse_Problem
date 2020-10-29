package com.bridgelabz.workshop.iplproblem;
import com.opencsv.bean.CsvBindByName;
public class IplBattingCsv {
	@CsvBindByName(column = "POS")
	public int pos;
	@CsvBindByName(column = "PLAYER")
	public String playerName;
	@CsvBindByName(column = "Mat")
	public Integer mat;
	@CsvBindByName(column = "Inns")
	public Integer inns;
	@CsvBindByName(column = "NO")
	public Integer no;
	@CsvBindByName(column = "Runs")
	public Integer runs;
	@CsvBindByName(column = "HS")
	public String highestScore;
	@CsvBindByName(column = "Avg")
	public Float average;
	@CsvBindByName(column = "BF")
	public Integer bf;
	@CsvBindByName(column = "SR")
	public Float strikeRate ;
	@CsvBindByName(column = "100")
	public Integer hundred;
	@CsvBindByName(column = "50")
	public Integer fifty;
	@CsvBindByName(column = "4s")
	public Integer four;
	@CsvBindByName(column = "6s")
	public Integer six;
	public Integer getPos() {
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
	public Integer getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public Integer getInns() {
		return inns;
	}
	public void setInns(Integer inns) {
		this.inns = inns;
	}
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public int getRuns() {
		return runs;
	}
	public void setRuns(Integer runs) {
		this.runs = runs;
	}
	public String getHighestScore() {
		return highestScore;
	}
	public void setHighestScore(String highestScore) {
		this.highestScore = highestScore;
	}
	public Float getAverage() {
		return average;
	}
	public void setAverage(Float average) {
		this.average = average;
	}
	public Integer getBf() {
		return bf;
	}
	public void setBf(Integer bf) {
		this.bf = bf;
	}
	public Float getStrikeRate() {
		return strikeRate;
	}
	public void setStrikeRate(Float strikeRate) {
		this.strikeRate = strikeRate;
	}
	public Integer getHundred() {
		return hundred;
	}
	public void setHundred(Integer hundred) {
		this.hundred = hundred;
	}
	public Integer getFifty() {
		return fifty;
	}
	public void setFifty(Integer fifty) {
		this.fifty = fifty;
	}
	public Integer getFour() {
		return four;
	}
	public void setFour(Integer four) {
		this.four = four;
	}
	public Integer getSix() {
		return six;
	}
	public void setSix(Integer six) {
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
