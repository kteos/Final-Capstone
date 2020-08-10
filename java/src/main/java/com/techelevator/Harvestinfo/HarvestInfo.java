package com.techelevator.Harvestinfo;

public class HarvestInfo {
	private int id;
	private int areaIdentifier;
	private String crop;
	private int count;
	private int weight;
	
	
	HarvestInfo() {
		
	}
	
	
	


	public int getAreaIdentifier() {
		return areaIdentifier;
	}

	public void setAreaIdentifier(int areaIdentifier) {
		this.areaIdentifier = areaIdentifier;
	}

	public String getCrop() {
		return crop;
	}

	public void setCrop(String crop) {
		this.crop = crop;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
