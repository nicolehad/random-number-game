package randomNumber;

import java.util.Scanner;

public class MethodsGuessingGame {

	public static int number (int level) 
	{
		int randomNumber = 0;
		int max = 0;
		int min = 0;
		
		if (level == 1)
		{
			max = 10;
			min = 1;
			
			randomNumber = (int)(Math.random()*((max-min)+1) + min);
		}
		
		if (level == 2)
		{
			max = 20;
			min = 1;
			
			randomNumber = (int)(Math.random()*((max-min)+1) + min);
		}
		
		if (level == 3)
		{
			max = 50;
			min = 1;
			
			randomNumber = (int)(Math.random()*((max-min)+1) + min);
		}
			
		
		return randomNumber;
	}
	
	public static String check(int randomNumber, int guess)
	{
		String check = "";
		
		if (guess == randomNumber)
		{
			check = "correct";
		}
		
		if (guess != randomNumber)
		{
			check = "incorrect";
		}
		
		return check;
	}
	
	public static String temperature(int randomNumber, int guess, int level)
	{
		String temperature = "";
		
		if (level == 1)
		{
			if ((guess <= randomNumber - 2 && guess >= randomNumber - 3)||(guess >= randomNumber + 2 && guess <= randomNumber + 3))
			{
				temperature = "Warm";
			}
			
			if ((guess < randomNumber - 3)||(guess > randomNumber + 3))
			{
				temperature = "Cold";
			}
			
			if ((guess == randomNumber - 1)||(guess == randomNumber + 1))
			{
				temperature = "Hot";
			}
		}
		
		if (level == 2)
		{
			if ((guess <= randomNumber - 5 && guess >= randomNumber - 8)||(guess >= randomNumber + 5 && guess <= randomNumber + 8))
			{
				temperature = "Warm";
			}
			
			if ((guess < randomNumber - 8)||(guess > randomNumber + 8))
			{
				temperature = "Cold";
			}
			
			if ((guess <= randomNumber - 1 && guess >= randomNumber - 4)||(guess >= randomNumber + 1 && guess <= 4))
			{
				temperature = "Hot";
			}
		}
		
		if (level == 3)
		{
			if ((guess <= randomNumber - 5 && guess >= randomNumber - 10)||(guess >= randomNumber + 5 && guess <= randomNumber + 10))
			{
				temperature = "Warm";
			}
			
			if ((guess < randomNumber - 10)||(guess > randomNumber + 10))
			{
				temperature = "Cold";
			}
			
			if ((guess <= randomNumber - 1 && guess >= randomNumber - 4)||(guess >= randomNumber + 1 && guess <= 4))
			{
				temperature = "Hot";
			}
		}
		return temperature;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String YN = " ";
		int level = 0;
		int guess = 0;
		int randomNumber = 0;
		String temperature = "";
		int lives = 3;

		do 
		{
			System.out.println();
			System.out.println("WELCOME TO THE RANDOM NUMBER GUESSING GAME");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			
			//LEVEL:
			System.out.println("Please select a level:");
			System.out.println("1 - Easy");
			System.out.println("2 - Medium");
			System.out.println("3 - Hard");
			
			level = input.nextInt();
			
			randomNumber = number(level);
			System.out.println("Number: " +randomNumber);
			
			while (lives != 0)
			{
				//LIVES:
				System.out.println("LIVES: " +lives);
				
				//GUESS:
				if (level == 1)
				{
					System.out.println("Guess a number between 1 and 10:");
				}
				
				if (level == 2)
				{
					System.out.println("Guess a number between 1 and 20:");
				}
				
				if (level == 3)
				{
					System.out.println("Guess a number between 1 and 50:");
				}
				
				guess = input.nextInt();
				
				//CHECK:
				System.out.println("Your guess was " +check(randomNumber, guess) + "!");
				
				//TEMPERATURE:
				temperature = temperature(randomNumber, guess, level);
				System.out.println(temperature);
				
				if (check(randomNumber, guess) == "correct")
					break;
				lives--;
			}

			//REVEAL NUMBER:
			if (lives == 0 && check(randomNumber, guess) == "incorrect")
				System.out.println("The number was: " +randomNumber);
				System.out.println();
			
			//PLAY AGAIN
			System.out.println("Would you like to play again? (Y/N)");
			YN = input.next();
			
		}while (YN != "N");
		
		
		
		
	}

}
