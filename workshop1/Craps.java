// for randomizing the dice roll
import java.util.Scanner;

public class Craps 
{
	int lastRoll;
	boolean end;
	Scanner enter = new Scanner(System.in);
	
	// class constructor
	Craps()
	{
		end = false;
		lastRoll = 0;
	}
	
	int rollDice()
	{
		int die1, die2 = 0;
		// this calculation for the probability of the dice roll returns a double value. We want to work will integers, so we use (int) to cast the value.
		die1 = (int) ((Math.random() * 6) + 1);
		die2 = (int) ((Math.random() * 6) + 1);
		
		return die1 + die2;
	}
	
	boolean isEqual(int roll)
	{
		boolean equal = false;
		if (roll == lastRoll)
		{
			equal = true;
		}
		
		return equal;
	}
	void initialRoll()
	{
		int roll = rollDice();
		System.out.println("Your first roll was " + roll + ".");
		switch (roll)
		{
			case 7: 
				System.out.println("You win!");
				end = true;
				break;
			case 11: 
				System.out.println("You win!");
				end = true;
				break;
			case 2:
				System.out.println("You lost.");
				end = true;
				break;
			case 3:
				System.out.println("You lost.");
				end = true;
				break;
			case 12:
				System.out.println("You lost.");
				end = true;
				break;
			default:
				// stores the value in member variable
				lastRoll = roll;
				System.out.println("You need to match this number in order to win.");
		}
	}
	
	void prompt()
	{
		enter.nextLine();
		end = false;
	}
	
	void subsequentRoll()
	{
		int roll = rollDice();
		// two display versions to ensure correct grammar
		if (roll == 11 || roll == 8)
		{
			System.out.println("You rolled an " + roll + ".");
		}
		else 
		{
			System.out.println("You rolled a " + roll + ".");
		}
		
		// displaying number and resetting values if the player rolled a winning or losing value
		if (roll == 7)
		{
			System.out.println("You lost.");
			end = true;
			lastRoll = 0;
		}
		else if (isEqual(roll))
		{
			System.out.println("You win!");
			end = true;
			lastRoll = 0;
		}
		else 
		{
			// updating member variable if the game is not over
			System.out.println("You need to match this number on your next roll in order to win.");
			lastRoll = roll;
		}
	}
	
///// START PROGRAM /////
	public static void main(String args[])
	{
		Craps crap = new Craps();

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~WELCOME TO CRAPS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Rules:\n");
		System.out.println("If you roll a 2, 3, or 12 on the first roll, you automatically lose! (This is called craps.)");
		System.out.println("If you roll a 7 or 11 on the first roll, you automatically win! (This is called natural.)");
		System.out.println("If you roll any other number, you get to roll again to try to match it.");
		System.out.println("After your first roll, you can only win if you roll the same number twice in a row.");
		System.out.println("If you roll a 7 after your first roll, you lose.");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		System.out.println("Press Enter when you're ready to start the game.");
		crap.prompt();
		crap.initialRoll();
		if (crap.end)
		{
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("Would you like to play again? (Press Enter)");
			crap.prompt();
		}
		while (!crap.end)
		{
			System.out.println("Press Enter to roll the dice.");
			crap.prompt();
			crap.subsequentRoll();
			if (crap.end)
			{
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("Would you like to play again? (Press Enter)");
				crap.prompt();
			}
		}
		///// END PROGRAM /////
		crap.enter.close();
	}
}
