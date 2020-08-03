package com.techelevator.harvest;

import java.io.FileNotFoundException;

public interface HarvestDao {
	void createHarvests(String path, String patha) throws FileNotFoundException;
}
