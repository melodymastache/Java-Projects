/**********************************************
Workshop #4
Course: JAC 444
Last Name: Mastache
First Name: Citlalli
ID: 126275189
Section: SAB
This assignment represents my own work in accordance with Seneca Academic Policy.
electronically signed by: Citlalli Mastache
Date: June 14th, 2019.
**********************************************/
package citlalliMastache_w4;
import java.io.*;

public class Numbers
{
	static char letters[][] = { {'A', 'B', 'C'} , // [0] -> 2 
						{'D', 'E', 'F'} , // [1] -> 3
						{'G', 'H', 'I'} , // [2] -> 4
						{'J', 'K', 'L'} , // [3] -> 5
						{'M', 'N', 'O'} , // [4] -> 6
						{'P', 'R', 'S'} , // [5] -> 7
						{'T', 'U', 'V'} , // [6] -> 8
						{'W', 'X', 'Y'} }; // [7] -> 9
	static String phoneNumber = "\0";
	static char number = 0;
	static int getLetterGroup(char num) 
	{
		//  groupNum = 0;
		return 0;
	}
	static void writeToFile() throws IOException
	{
		// accessing file
		File file = new File("output.txt");
		file.createNewFile();
		FileWriter writer = new FileWriter(file);
		for (int i = 0; i < 7; i++) // as long as the words can be because of the 7-digit number inputed
		{
			for(int index1 = 0; index1 < letters[0].length; index1++)
			{
				for (int index2 = 0; index2 < 3; index2++) // number of letters in each group
				{
					writer.write(letters[index1][index2]);
					System.out.print(letters[index1][index2]);
				}
			}
		}
		writer.close();
	}
	
	// validates the user input
	static boolean same()
	{
		return phoneNumber.matches("[2-9][2-9][2-9][2-9][2-9][2-9][2-9]");
	}
	
	public static void main(String[] args) throws IOException
	{
		do
		{
			System.out.println("Please enter a 7-digit phone number that matches the pattern: '0000000'");
			//Scanner scan = new Scanner(System.in);
			phoneNumber = "2222222"; //scan.next();
			if (!same() || (phoneNumber.length() > 7))
			{
				System.out.println("Sorry, the digits can only be from 2-9. You input can only be 7 characters long. Please try again.");
				phoneNumber = "\0";
			}
			//scan.close();
		} while (phoneNumber == "\0");
		for (int i = 0; i < phoneNumber.length(); i++) 
		{
			number = phoneNumber.charAt(i);
			writeToFile();
		}
	}

}
