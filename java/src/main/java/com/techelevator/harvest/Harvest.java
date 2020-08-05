package com.techelevator.harvest;

public class Harvest {
	private int id;
	private String crop;
	private int directSeedToHarvestTime;
	
	public Harvest ( ) {
		
	}
	
	public Harvest (String crop, int directSeedToHarvestTime) {
		this.crop = crop;
		this.directSeedToHarvestTime = directSeedToHarvestTime;
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

	public int getDirectSeedToHarvestTime() {
		return directSeedToHarvestTime;
	}

	public void setDirectSeedToHarvestTime(int directSeedToHarvestTime) {
		this.directSeedToHarvestTime = directSeedToHarvestTime;
	}
	
}
