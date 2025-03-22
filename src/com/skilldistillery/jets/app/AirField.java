package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.entities.CargoPlane;
import com.skilldistillery.jets.entities.Fighter;
import com.skilldistillery.jets.entities.Jet;
import com.skilldistillery.jets.entities.JetImpl;

public class AirField {
	
	private Scanner scanner = new Scanner(System.in);

		// using an array list data structure to hold the collection of Jet objects
	private List<Jet> fleet = new ArrayList<>();

		// reading in the jets from a text file
	public AirField() {
			// load the data about jets from text file
		loadJetsFromFile("jetData.txt");
	}

			//TODO BufferedReader recipe here to read from fileName with Try/Catch
			//see nameSeperator and Planets examples of how to read jets into the ArrayList from text file.  
	
	public List<Jet> loadJetsFromFile(String fileName) {
		try ( BufferedReader bufIn = new BufferedReader(new FileReader("jetData.txt")) ) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				Jet j;
	//			System.out.println(line);
				String[] fields = line.split(",");
				String category = fields[0];
				String model = fields[1];
				double speed = Double.parseDouble(fields[2]);
				int range = Integer.parseInt(fields[3]);
				long price = Long.parseLong(fields[4]);
				switch (category) {
				case "Passenger":
					j = new JetImpl(model, speed, range, price);
					fleet.add(j);
					break;
					
				case "CombatReady":
					j = new Fighter(model, speed, range, price);
					fleet.add(j);
					break;
					
				case "Cargo":
					j = new CargoPlane(model, speed, range, price);
					fleet.add(j);
					break;
							}
			}
			}

		catch(IOException e){
			System.err.println(e);
		}
		return fleet;
		
	}
		
	public void displayJets() {
		System.out.println(fleet);
	}

//private class AirField {
	public void quit() {
		System.out.println("Hope you enjoyed your visit to check out the jets at the air field.");
	}
}
