package com.techelevator.transplant;


public class Transplant {
	
	private int id;
	private String crop;
	private int directSeedToTransplantTime;
	private int transplantToHarvestTime;
	
	public Transplant() {
		
	}
	
	public Transplant(String crop, int directSeedToTransplantTime, int transplantToHarvestTime) {
		this.crop = crop;
		this.directSeedToTransplantTime = directSeedToTransplantTime;
		this.transplantToHarvestTime = transplantToHarvestTime;
	}
	
	public String getCrop() {
		return crop;
	}
	
	public void setCrop(String crop) {
		this.crop = crop;
	}
	
	public int getDirectSeedToTransplantTime() {
		return directSeedToTransplantTime;
	}
	
	public void setDirectSeedToTransplantTime(int directSeedToTransplantTime) {
		this.directSeedToTransplantTime = directSeedToTransplantTime;
	}
	
	public int getTransplantToHarvestTime() {
		return transplantToHarvestTime;
	}
	
	public void setTransplantToHarvestTime(int transplantToHarvestTime) {
		this.transplantToHarvestTime = transplantToHarvestTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


}
