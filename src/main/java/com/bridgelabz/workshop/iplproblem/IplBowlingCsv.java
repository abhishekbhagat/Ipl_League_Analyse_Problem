package com.bridgelabz.workshop.iplproblem;
import com.opencsv.bean.CsvBindByName;
public class IplBowlingCsv {
	@CsvBindByName(column = "POS")
	public int pos;
	@CsvBindByName(column = "PLAYER")
	public String playerName;
	@CsvBindByName(column = "Mat")
	public Integer mat;
	@CsvBindByName(column = "Inns")
	public Integer inns;
	@CsvBindByName(column = "Ov")
	public Float over;
	@CsvBindByName(column = "Runs")
	public Integer runs;
	@CsvBindByName(column = "Wkts")
	public Integer wicket;
	@CsvBindByName(column = "BBI")
	public Integer bbi;
	@CsvBindByName(column = "Avg")
	public Float average;
	@CsvBindByName(column = "Econ")
	public Float economy;
	@CsvBindByName(column = "SR")
	public Float strikeRate;
	@CsvBindByName(column = "4w")
	public Integer fourwicket;
	@CsvBindByName(column = "5w")
	public Integer fivewicket;
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
	public Integer getMat() {
		return mat;
	}
	public void setMat(Integer mat) {
		this.mat = mat;
	}
	public Integer getInns() {
		return inns;
	}
	public void setInns(Integer inns) {
		this.inns = inns;
	}
	public Float getOver() {
		return over;
	}
	public void setOver(Float over) {
		this.over = over;
	}
	public Integer getRuns() {
		return runs;
	}
	public void setRuns(Integer runs) {
		this.runs = runs;
	}
	public Integer getWicket() {
		return wicket;
	}
	public void setWicket(Integer wicket) {
		this.wicket = wicket;
	}
	public Integer getBbi() {
		return bbi;
	}
	public void setBbi(Integer bbi) {
		this.bbi = bbi;
	}
	public Float getAverage() {
		return average;
	}
	public void setAverage(Float average) {
		this.average = average;
	}
	public Float getEconomy() {
		return economy;
	}
	public void setEconomy(Float economy) {
		this.economy = economy;
	}
	public Float getStrikeRate() {
		return strikeRate;
	}
	public void setStrikeRate(Float strikeRate) {
		this.strikeRate = strikeRate;
	}
	public Integer getFourwicket() {
		return fourwicket;
	}
	public void setFourwicket(Integer fourwicket) {
		this.fourwicket = fourwicket;
	}
	public Integer getFivewicket() {
		return fivewicket;
	}
	public void setFivewicket(Integer fivewicket) {
		this.fivewicket = fivewicket;
	}
	
	@Override
	public String toString() {
		return "IplBowlingCsv [pos=" + pos + ", playerName=" + playerName + ", mat=" + mat + ", inns=" + inns
				+ ", over=" + over + ", runs=" + runs + ", wicket=" + wicket + ", bbi=" + bbi + ", average=" + average
				+ ", economy=" + economy + ", strikeRate=" + strikeRate + ", fourwicket=" + fourwicket + ", fivewicket="
				+ fivewicket + "]";
	}
}