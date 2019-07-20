/**********************************************
Workshop #8
Course: JAC 444
Last Name: Mastache
First Name: Citlalli
ID: 126275189
Section: SAB
This assignment represents my own work in accordance with Seneca Academic Policy.
electronically signed by: Citlalli Mastache
Date: July 19th, 2019.
**********************************************/

package workshop8;
import java.util.HashMap;
import java.util.Scanner;

// Your program should prompt the user to enter a state and should display the capital for the state. 

public class Map {
	static HashMap<String, String> map = new HashMap<String, String>();
	static boolean exit = false;
	
	public static void createMap() {
		// country is key, city is value
		map.put("ENGLAND", "LONDON");
	    map.put("GERMANY", "BERLIN");
	    map.put("NORWAY", "OSLO");
	    map.put("USA", "WASHINGTON DC");
	    map.put("CANADA", "OTTAWA"); //5
	    map.put("ARGENTINA", "BUENOS AIRES");
	    map.put("MEXICO", "MEXICO CITY");
	    map.put("COLOMBIA", "BOGOTA");
	    map.put("CHILE", "SANTIAGO");
	    map.put("CHINA", "BEIJING"); //10
	    map.put("CUBA", "HAVANA");
	    map.put("DENMARK", "COPENHAGEN");
	    map.put("EGYPT", "CAIRO");
	    map.put("FRANCE", "PARIS");
	    map.put("GREECE", "ATHENS"); //15
	    map.put("INDIA", "NEW DELHI");
	    map.put("IRELAND", "DUBLIN");
	    map.put("JAPAN", "TOKYO");
	    map.put("JAMAICA", "KINGSTON");
	    map.put("LEBANON", "BEIRUT"); //20
	    map.put("LUXEMBOURG", "LUXEMBOURG");
	    map.put("NETHERLANDS", "AMSTERDAM");
	    map.put("PERU", "LIMA");
	    map.put("PORTUGAL", "LISBON");
	    map.put("RUSSIA", "MOSCOW"); //25
	}
	
	public void run() 
	{
		createMap();
		Scanner in = new Scanner(System.in);
		/////////////////////// START PROGRAM ////////////////////////
		System.out.println("This program has a list of 25 countries and their capital cities. Here is the list of countries available: ");
		for (String i: map.keySet()) {
			System.out.println("- " + i);
		}
		do {
			System.out.println("\nEnter a country from the list: ");
			String prompt = in.nextLine();
			if (map.containsKey(prompt.toUpperCase())) {
				System.out.println("The capital of " + prompt + " is " + map.get(prompt.toUpperCase()));
			}
			else {
				System.out.println("Sorry, that country is not on the list. Please try again.");
			}
			System.out.println("Would you like to try another country? (Y/N): ");
			String answer = in.nextLine();
			if (answer.charAt(0) == 'Y' || answer.charAt(0) == 'y') {
				exit = false;
			}
			else {
				exit = true;
			}
		}
		while (!exit);
		in.close();
		//////////////////////// END PROGRAM //////////////////////////
	}
}
