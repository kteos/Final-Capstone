package com.techelevator.crops;

import java.util.List;

public interface CropsDao {
	void createCrops (List<Crops> crops , String user);
	List<Crops> getAllCrops( String user );
	void updateCrops(Crops crop , String user);
}
