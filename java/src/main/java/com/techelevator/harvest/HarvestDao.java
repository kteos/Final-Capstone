package com.techelevator.harvest;

import java.util.List;

public interface HarvestDao {
	void createHarvests( Harvest[] harvest );
	public  List<Harvest> cropNames();
	Harvest updateHarvest(Harvest harvest);
}



