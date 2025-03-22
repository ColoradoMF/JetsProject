package com.skilldistillery.jets.entities;

public class CargoPlane extends Jet {

	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	public void loadCargo() {
		System.out.println("The cargo plane that's being loaded is: " + getModel());
	}
	
}
