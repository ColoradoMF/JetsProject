package com.skilldistillery.jets.app;

import java.util.Iterator;
import java.util.Scanner;

public class JetsApplication {
		
		// No Jet collection in App class, only in Airfield
		// only class with a main, constructs an object of its own type
		//
	
	private AirField airField = new AirField(); // instantiates object right in declaration
	private static Scanner scanner;
	
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		JetsApplication app = new JetsApplication();
		app.launchMenu();  // launch
		
		scanner.close();
	}

	private void launchMenu() {
		boolean menuLoop = true;
		String menuChoice;
		System.out.println("\n\n");
		
		// TODO Create an AirField for anything having to do with the planes
		// do-while loop to display user menu
		// *print menu in its own method
		// *get user choice
		// *switch on user choice to list all jets, fly all jets menu options
				// instantiate a jet in the method class and pass to airfield to add to its jets collection 
		// * call an AirField method to act on user choice
		
		while (menuLoop) {
		displayUserMenu();
		menuChoice = scanner.next();
		scanner.nextLine();
			
		switch(menuChoice) {
		
			case "1": {
				airField.displayJets();
				continue;
			}
			
			case "2": {
				airField.flyJets();
				continue;
			}
			
			case "3": {
				airField.determineFastest();
				continue;
			}
			
			case "4": {
				airField.determineLongestRange();
				continue;
			}
			
			case "5": {
				airField.loadAllCargoPlanes();
				continue;
			}
			
			case "6": {
				airField.fight();
				continue;
			}
			
			case "7": {
				addJetToFleet();
				continue;
			}
			
			case "8": {
				removeJetFromFleet();
				continue;
			}
			
			case "9": {
				airField.quit();
				menuLoop = false;
				break;
			}
				
			default:
				System.out.println("Invalid selection, kindly key in a number between 1 and 9.");
				continue;
			}
		
		}
	}
//	}
	
	private void displayUserMenu() {
		//TODO - sysouts to show main menu here so not in do - while loop
		System.out.println("=========================================");
		System.out.println("==              Jets (Menu)            ==");
		System.out.println("==Press a ## for your selected action  ==");
		System.out.println("=========================================");
		System.out.println("== 1. List all jets in fleet.          ==");
		System.out.println("== 2. Fly all jets in fleet.           ==");
		System.out.println("== 3. View the fastest jet in fleet.   ==");
		System.out.println("== 4. View the jet with longest range. ==");
		System.out.println("== 5. Order all cargo jets loaded.     ==");
		System.out.println("== 6. Dogfight all military jets.      ==");
		System.out.println("== 7. Add a new jet to the fleet.      ==");
		System.out.println("== 8. Remove a jet from the fleet.     ==");
		System.out.println("== 9. Quit and exit Jets application.  ==");
		System.out.println("=========================================");
	}
	
	private void addJetToFleet() {
		String model;
		double speed;
		int range;
		long price;
		String category;
		
		System.out.println("What model of jet would you like to add? ");
		model = scanner.nextLine();

		System.out.println("What is the top speed of the jet you would like to add? ");
		speed = scanner.nextDouble();
		
		System.out.println("What is the range of jet would you like to add? ");
		range = scanner.nextInt();
		
		System.out.println("What is the price of the jet would you like to add? ");
		price = scanner.nextLong();
		scanner.nextLine();
		
		System.out.println("What is the category of the jet you'll to add to the fleet? ");
		System.out.println("Press P to add a Passenger Jet");
		System.out.println("Press C to add a Cargo Carrier Jet");
		System.out.println("Press M to add a Military Fighter Jet");
		category = scanner.nextLine();
		
		switch(category) {
		case "P":
			airField.addPassengerJet(model, speed, range, price);
		case "C":
			airField.addCargoPlane(model, speed, range, price);
		case "M":
			airField.addFighter(model, speed, range, price);
		}
	}
	
	private void removeJetFromFleet() {
			int indexChoice;
			for (int i = 0; i < airField.getFleet().size(); i++) {
				System.out.println((i+1) + ". " + airField.getFleet().get(i).getModel());
			
			}
			System.out.println("Select the number of the jet would you like to remove.");
			indexChoice = scanner.nextInt();
			scanner.nextLine();
			
			indexChoice = indexChoice - 1;
			airField.removeSelectedJet(indexChoice);
	}
		
}
	

