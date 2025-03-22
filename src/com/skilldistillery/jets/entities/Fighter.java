package com.skilldistillery.jets.entities;

public class Fighter extends Jet {

	public Fighter(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
		
	}

	public void fight() {
		System.out.println(getModel() + " orders received... PEW PEW");
	}
		

}
