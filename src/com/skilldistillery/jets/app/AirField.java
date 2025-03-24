package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.jets.entities.CargoPlane;
import com.skilldistillery.jets.entities.Fighter;
import com.skilldistillery.jets.entities.Jet;
import com.skilldistillery.jets.entities.JetImpl;

public class AirField {

	// using an array list data structure to hold the collection of Jet objects
	private List<Jet> fleet; 

	// reading in the jets from a text file
	public AirField() {
		// load the data about jets from text file
		loadJetsFromFile("jetData.txt");
	}

	// TODO BufferedReader recipe here to read from fileName with Try/Catch
	// see nameSeperator and Planets examples of how to read jets into the ArrayList
	// from text file.

	public List<Jet> loadJetsFromFile(String fileName) {
		try (BufferedReader bufIn = new BufferedReader(new FileReader("jetData.txt"))) {
			setFleet(new ArrayList<>());
			String line;
			while ((line = bufIn.readLine()) != null) {
				Jet j;
				// System.out.println(line);
				String[] fields = line.split(",");
				String category = fields[0];
				String model = fields[1];
				double speed = Double.parseDouble(fields[2]);
				int range = Integer.parseInt(fields[3]);
				long price = Long.parseLong(fields[4]);
				switch (category) {
				case "Passenger":
					j = new JetImpl(model, speed, range, price);
					getFleet().add(j);
					break;

				case "CombatReady":
					j = new Fighter(model, speed, range, price);
					getFleet().add(j);
					break;

				case "CargoCarrier":
					j = new CargoPlane(model, speed, range, price);
					getFleet().add(j);
					break;
				}
			}
		}

		catch (IOException e) {
			System.err.println(e);
		}
		return getFleet();

	}

	public void displayJets() {
		System.out.println(getFleet());
	}

//private class AirField {
	public void quit() {
		System.out.println("Hope you enjoyed your visit to check out the jets at the air field.");
	}

	public void flyJets() {
		for (Jet jet : getFleet()) {
			jet.fly();
		}
	}

	public void determineFastest() {
		Jet fastestJet = getFleet().get(0);
		for (Jet jet : getFleet()) {
			if (jet.getSpeed() > fastestJet.getSpeed()) {
				fastestJet = jet;
			}
		}
		System.out.println("The fastest jet in the fleet is :" + fastestJet);
	}

	public void determineLongestRange() {
		Jet longestRange = getFleet().get(0);
		for (Jet jet : getFleet()) {
			if (jet.getRange() > longestRange.getRange()) {
				longestRange = jet;
			}
		}
		System.out.println("The jet with the longest range is :" + longestRange);
	}

	public void loadAllCargoPlanes() {
		for (Jet jet : getFleet()) {
			if (jet instanceof CargoPlane) {
				((CargoPlane) jet).loadCargo();
			}
		}
	}
	
	public void fight() {
		for (Jet jet : getFleet()) {
			if (jet instanceof Fighter) {
				((Fighter) jet).fight();
			}
		}
	}
	
	public void addPassengerJet(String model, double speed, int range, long price) {
		Jet newJet = new JetImpl(model, speed, range, price);
		getFleet().add(newJet);
	}
	
	public void addCargoCarrier(String model, double speed, int range, long price) {
		Jet newJet = new JetImpl(model, speed, range, price);
		getFleet().add(newJet);
	}
	
	public void addFighter(String model, double speed, int range, long price) {
		Jet newJet = new Fighter(model, speed, range, price);
		getFleet().add(newJet);
	}

	public void addCargoPlane(String model, double speed, int range, long price) {
		Jet newJet = new CargoPlane(model, speed, range, price);
		getFleet().add(newJet);		
	}

	public List<Jet> getFleet() {
		return fleet;
	}

	public void setFleet(List<Jet> fleet) {
		this.fleet = fleet;
	}

	public void removeSelectedJet(int indexChoice) {
		fleet.remove(indexChoice);
	}
}
