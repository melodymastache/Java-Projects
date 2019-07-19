/**********************************************
Workshop #4
Course: JAC 444
Last Name:Mastache
First Name: Citlalli
ID: 126275189
Section: SAB
This assignment represents my own work in accordance with Seneca Academic Policy.
electronically signed by: Citlalli Mastache
Date: June 14th, 2019.
**********************************************/
package citlalliMastache_w4;
import java.util.Scanner;
import java.io.*;

public class TesterClass
{
	// creating static variables to track characters read from file
	static String currentLine = "\0";
	int size = 26; // the number of letters in the alphabet
	static int alphabetCount[] = new int[27]; // to keep track of the count
	static char alphabet[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	
	///////////////// START PROGRAM /////////////////////
	public static void main(String[] args) throws IOException
	{
		
		// prompting user for file name
		System.out.print("Enter a file name: "); // Type in "Crush";
		Scanner in = new Scanner(System.in);
		String str = in.nextLine() + ".txt";
		BufferedReader buffRead = null;
		try 
		{
				// accessing file		
				File file = new File(str);
				buffRead = new BufferedReader(new FileReader(file));
				while ((currentLine = buffRead.readLine()) != null)
				{
					// changing values in string to upper case, which could not be done within the while condition due to null exception
					currentLine = currentLine.toUpperCase();
					// checking every line for each letter of the alphabet
					for(int j = 0; j < alphabet.length; j++)
					{
						// reinitializing count variable to ensure it is always counting a new value
						int count = 0;
						for (int i = 0; i < currentLine.length(); i++)
						{
							if (currentLine.charAt(i) == alphabet[j])
							{
								count++;
							}
						}
						// adding together current count with previous count and adding that value to the array
						alphabetCount[j] += count;
					}
				}
				// for every letter of the alphabet, printing the values
				for (int i = 0; i < alphabet.length; i++)
				{
					System.out.println("Number of " + alphabet[i] + "'s: " + alphabetCount[i]);				
				}
		} 
		catch (FileNotFoundException e) 
		{
			// exception thrown if file cannot be located
			System.out.println("File Not Found.");
			throw e;
		}
		finally 
		{
			// closing streams to avoid resource leaks
			in.close();
			buffRead.close();
		}
	}
		//////////////// END PROGRAM //////////////////////
}
