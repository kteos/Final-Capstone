package com.techelevator.harvest;

import java.util.List;

public interface HarvestDao {
	void createHarvests( Harvest[] harvest , String username );
	public  List<Harvest> cropNames(String username);
	Harvest updateHarvest(Harvest harvest, String username );
}



