package com.example.springframeworkproject2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FileLoad {

	@JsonProperty("순번")
	private int seq;
	@JsonProperty("지자체명")
	private String city;
	@JsonProperty("업종")
	private String sector;
	@JsonProperty("단계")
	private int stage;
	@JsonProperty("구간시작(세제곱미터)")
	private int startSection;
	@JsonProperty("구간끝(세제곱미터)")
	private int endSection;
	@JsonProperty("구간금액(원)")
	private int sectionPrice;
	@JsonProperty("단계별 기본요금(원)")
	private int charge;

	public FileLoad(int seq, String city, String sector, int stage, int startSection, int endSection, int sectionPrice) {
		this.seq = seq;
		this.city = city;
		this.sector = sector;
		this.stage = stage;
		this.startSection = startSection;
		this.endSection = endSection;
		this.sectionPrice = sectionPrice;
		this.charge = charge;
	}

	public FileLoad() {
	}

	public int getSeq() {
		return seq;
	}

	public String getCity() {
		return city;
	}

	public String getSector() {
		return sector;
	}

	public int getStage() {
		return stage;
	}

	public int getStartSection() {
		return startSection;
	}

	public int getEndSection() {
		return endSection;
	}

	public int getSectionPrice() {
		return sectionPrice;
	}

	public int getCharge() {
		return charge;
	}

	@JsonProperty("순번")
	public void setSeq(int seq) {
		this.seq = seq;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public void setStage(int stage) {
		this.stage = stage;
	}

	public void setStartSection(int startSection) {
		this.startSection = startSection;
	}

	public void setEndSection(int endSection) {
		this.endSection = endSection;
	}

	public void setSectionPrice(int sectionPrice) {
		this.sectionPrice = sectionPrice;
	}

	public void setCharge(int charge) {
		this.charge = charge;
	}

	@Override
	public String toString() {
		return
			"  city  :  " + city  +
				" sector  :  " + sector +
				" unitPrice :  " + sectionPrice +
				" billTotal  :  " + charge + '\n'
			;
	}
}
