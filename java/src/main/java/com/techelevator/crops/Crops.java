package com.techelevator.crops;

import java.time.LocalDate;

public class Crops {
	
	int id;
	String area;
	String crop;
	LocalDate plantingDate;
	
	public Crops(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCrop() {
		return crop;
	}

	public void setCrop(String crop) {
		this.crop = crop;
	}

	public LocalDate getPlantingDate() {
		return plantingDate;
	}

	public void setPlantingDate(LocalDate plantingDate) {
		this.plantingDate = plantingDate;
	}
	
}
