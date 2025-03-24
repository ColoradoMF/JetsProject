package com.skilldistillery.jets.entities;

public abstract class Jet {

	// Needs the following:
	// fields for model, speed, range, price - done
	// methods to fly and convert MPH speed to Mach - done
	// getters and setters - done
	// toString - done

	private String model;
	private double speed = 0.0; // MPH
	private int range = 0; // Miles
	private long price = 0;


public void fly() {
	System.out.println("This jet is model " + model + " which costs " + price + ".  Currently, it is flying at " + speed + 
			" mph and can fly at this speed for " + getRangeInHours() + " hours with the range of " + range + " miles.");
}

public double getRangeInHours() {
	double rangeInHours = range / speed;
	return rangeInHours; // FIXME
}
	
// cargo jet implements CargoCarrier interface	
	public Jet(String model, double speed, int range, long price) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Jet [model=").append(model).append(", speed=").append(speed).append(", range=").append(range)
				.append(", price=").append(price).append("]");
		return builder.toString();
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

}


