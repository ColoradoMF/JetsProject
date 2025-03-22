package com.skilldistillery.jets.entities;
	// JetImpl implements the Jet class ie. this is a business jet
public class JetImpl extends Jet {

	//  need constructor by generating from superclass
	
	public JetImpl(String model, double speed, int range, long price) {
		super(model, speed, range, price);  // calls Jet version of constructor 
		
	}
	
}
