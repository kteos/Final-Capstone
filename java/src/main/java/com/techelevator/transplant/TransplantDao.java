package com.techelevator.transplant;

import java.util.List;

public interface TransplantDao {
	
	void createTransplants( Transplant[] transplant );
	public  List<Transplant> listTransplant();
	Transplant updateTransplant(Transplant transplant);

}
