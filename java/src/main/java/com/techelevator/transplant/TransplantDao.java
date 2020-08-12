package com.techelevator.transplant;

import java.util.List;

public interface TransplantDao {
	
	void createTransplants( Transplant[] transplant , String userName  );
	public  List<Transplant> listTransplant( String user );
	Transplant updateTransplant(Transplant transplant , String user );

}
