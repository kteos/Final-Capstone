package com.techelevator.crops;

import java.util.List;

public interface CropsDao {
	void createCrops (List<Crops> crops);
	List<Crops> getAllCrops();
	void updateCrops(Crops crop);
}
