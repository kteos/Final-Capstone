package com.techelevator.expiration;

public class Expiration {
	private int id;
	private String crop;
	private int daysToExpire;

	public Expiration() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCrop() {
		return crop;
	}

	public void setCrop(String crop) {
		this.crop = crop;
	}

	public int getDaysToExpire() {
		return daysToExpire;
	}

	public void setDaysToExpire(int daysToExpire) {
		this.daysToExpire = daysToExpire;
	}

}
