package com.skilldistillery.jets.app;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.jets.entities.Jet;

public class AirField {

		// using an array list
		private List<Jet> fleet = new ArrayList<>();
		
		// reading jets from a text file
		public AirField() {
			// load the data about jets from text file
			loadJetsFromFile("jetData.txt");
		}
		
		public void loadJetsFromFile(String fileName) {
			//TODO BufferedReader recipe here to read from fileName with Try/Catch
			//see nameSeperator and Planets for 
			//
			
			try ( BufferedReader bufIn = new BufferedReader(new FileReader("jetData.txt")) ) {
				  String line;
				  while ((line = bufIn.readLine()) != null) {
				    System.out.println(line);
				  }
				}
				
			
			String line;
			String[] firelds = line.split(",");
			String model = fields[1];
			double speed = Double.parseDouble(fields[2]);
			
			
			switch (fields[0]) {
			case "Passenger":
				Jet j = new JetImpl("model", speed, etc);
				break;
			case "Fighter":
				Jet j = new CombatReady("");
			case "Cargo":
				Jet j = new CargoCarrier("");
			case "":
				Jet j = new 
				
			}
		}
		
		catch (IOException e) {
			  System.err.println(e);
			}
		
		}
	
//private class AirField {

