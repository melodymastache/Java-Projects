// importing the scanner class for user input
import java.util.Scanner;
// Math.random to pick word from array
import java.util.Random;
// regex validation
import java.util.regex.*;

public class Hangman 
{
	public static class Game {
		final String[] animalsArray = {"elephant", "monkey", "giraffe", "orangutan", "zebra", "kangaroo", "lion"};
		final String guess = "(Guess) Enter a letter in word ";
		Random r;
		String animal;
		String currentWord;
		String guessedLetters;
		int randomNumber;
		int size;
		int attempts;
		int maxAttempts;
		char letter;
		
		void set()
		{
			// the next three lines randomly choose an animal from the array
			r = new Random();
			randomNumber = r.nextInt(animalsArray.length); 
			animal = animalsArray[randomNumber];
			currentWord = "";
			currentWord = fill(currentWord); // overwrites current word with asterisks
			size = currentWord.length();
			attempts = 0;
			maxAttempts = 15; // 15 tries until answer is revealed.
			letter = '\0';
			guessedLetters = "";
		}
		
		String fill(String str) 
		{
			// filling dynamic variable with asterisks for exact length of target word
			for (int i = 0; i < animal.length(); i++) 
			{
				str += "*";
			}
			return str;
		}
		
		boolean validate(String str)
		{
			boolean valid = false;
			if (str.length() > 1)
			{
				// accounts for any input longer than one character
				System.out.println("You entered too many characters. Please try again.");
			}
			else if (!Pattern.matches("[A-Za-z]", str))
			{
				// accounts for any input that is not exactly one character AND not part of the alphabet
				System.out.println("You entered a character outside of the alphabet. Please try again.");
			}
			else if (Pattern.matches("^[A-Za-z]", str))
			{
				// when we receive the desired input, we set boolean to true
				letter = str.charAt(0);
				valid = true;
				attempts++;
			} 
			else
			{
				System.out.println("ERROR: Cannot accept input.");
			}
			return valid; 
		}
		
		// check if the current guess has been made before/tracks current guesses
		boolean previousGuess(char in) 
		{
			boolean found = false;
			for (int n = 0; n < guessedLetters.length(); n++)
			{
				if (guessedLetters.charAt(n) == in)
				{
					System.out.println("You've already tried this letter. Please try entering another letter.");
					found = true;
				}
			}
			return found;
		}
		
		boolean searchAnimal(char in)
		{
			boolean found = false;
			for (int i = 0; i < size; i++)
			{
				if (animal.charAt(i) == in)
				{
					found = true;
					currentWord = update(in, i);
				}
			}
			return found;
		}
		
		boolean find(char input)
		{
			boolean match = false;
			if (!previousGuess(input))
			{
				guessedLetters += input;
			}
			if (!searchAnimal(input))
			{
				System.out.println("Sorry, the letter you guessed is not part of the word. Please try again.");
			}
			return match;
		}
		
		boolean play(char answer) 
		{
			boolean response = false;
			if (answer == 'y' || answer == 'Y')
			 {
				response = true;
			 }
			return response;
		}
		
		boolean end()
		{
			boolean finished = false;
			 if (attempts == maxAttempts)
			 {
				 finished = true;
			 }
			return finished;
		}
		
		boolean correct()
		{
			boolean finished = false;
			if (currentWord.equals(animal))
			{
				finished = true;
			}
			//System.out.println(finished);  // TEST STRING
			return finished;
		}
		
		String update(char in, int index)
		{
			// creating a string to manipulate data
			StringBuilder strBuild = new StringBuilder(currentWord);
			strBuild.setCharAt(index, in);
			String str = strBuild.toString();
			return str;
		}
	}
	
//////////START PROGRAM/////////
	public static void main(String[] args) 
	{	
		Game hangman = new Game();
		hangman.set();
		Scanner obj = new Scanner(System.in);
		String input;
		char start;
		
		////// DISPLAY HEADER //////
		System.out.println("Welcome to Hangman!");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("You will have 15 tries to guess the word.");
		System.out.println("The category is animals.");
		System.out.println("Enter (Y)es/(y)es to begin the game or (N)o/(n)o to exit.\n> ");
		input = obj.next();
		start = input.charAt(0);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		while (hangman.play(start))
		{
			input.strip();
			guess: while (!hangman.end() || !hangman.correct())
			{
				System.out.print(hangman.guess + hangman.currentWord + "\n> "); 
				input = obj.next();
				if (hangman.validate(input))
				{
					input.strip();
					if (hangman.correct())
					{
						System.out.println("Congratulations! You guessed the word correctly.");
						break guess;
					}
					else if (hangman.end())
					{
						System.out.println("Sorry, you've run out of chances to guess.");
						break guess;
					}
					else 
					{
						hangman.find(hangman.letter);
						//System.out.println(hangman.animal + hangman.currentWord); // TEST STRING
					}
				}
			  
			 }
			/////// DISPLAY STATISTICS ///////
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("You guessed " + hangman.attempts + " times.");
			System.out.println("The correct answer was: " + hangman.animal);
			System.out.println("Would you like to play again?\n> ");
			start = obj.next().charAt(0);
			if (hangman.play(start))
			{
				hangman.set();
			}
		 }
		System.out.println("Goodbye.");
		obj.close();
	}
///////////END PROGRAM//////////
}
