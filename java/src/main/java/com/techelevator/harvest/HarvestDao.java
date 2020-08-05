package com.techelevator.harvest;

import java.io.FileNotFoundException;

public interface HarvestDao {
	void createHarvests(String path) throws FileNotFoundException;
}
