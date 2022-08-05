package game;

import java.util.*;

public class Hangman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] answer;
		char[] current = new char[100];
		ArrayList<Character> guessed = new ArrayList<Character>();
		Scanner scan = new Scanner(System.in);
		int guesses = 0;
		System.out.println("Welcome to Hangman! Enter a Word in Secret: ");
		answer = scan.nextLine().toCharArray();
		for(int i = 0; i < answer.length; i++)
		{
			if(answer[i] != ' ')
			{
				current[i] = current[i] = '_';
			}
		}
		for(int i = 0; i < 100; i++)
		{
			System.out.println("________________________");
		}
		while(guesses < 6)
		{
			System.out.println("Enter Your Guess!");
			char[] input = scan.nextLine().toCharArray();
			if (guessed.contains(input[0]) || input.length > 1)
			{
				System.out.println("Invalid!!");
				continue;
			}
			char hold = input[0];
			guessed.add(hold);
			boolean hit = false;
			for(int k = 0; k < answer.length; k++)
			{
				if(hold <= 90)
				{
					if(answer[k] == hold || answer[k] == hold + 32)
					{
						current[k] = hold;
						hit = true;
					}
				}
				else
				{
					if(answer[k] == hold || answer[k] == hold - 32)
					{
						current[k] = hold;
						hit = true;
					}
				}
			}
			if(!hit)
			{
				guesses++;
			}
			if(guesses == 0)
			{
				System.out.println(" ______    ");
				System.out.println(" |    |    ");
				System.out.println(" |         ");
				System.out.println(" |         ");
				System.out.println(" |         ");
				System.out.println("___        \n");
			}
			if(guesses == 1)
			{
				System.out.println(" ______    ");
				System.out.println(" |    |    ");
				System.out.println(" |    o    ");
				System.out.println(" |         ");
				System.out.println(" |         ");
				System.out.println("___        \n");
			}
			if(guesses == 2)
			{
				System.out.println(" ______    ");
				System.out.println(" |    |    ");
				System.out.println(" |    o    ");
				System.out.println(" |    |   ");
				System.out.println(" |    |    ");
				System.out.println("___      \n");
			}
			if(guesses == 3)
			{
				System.out.println(" ______    ");
				System.out.println(" |    |    ");
				System.out.println(" |    o    ");
				System.out.println(" |    | /  ");
				System.out.println(" |    |    ");
				System.out.println("___        \n");
			}
			if(guesses == 4)
			{
				System.out.println(" ______    ");
				System.out.println(" |    |    ");
				System.out.println(" |    o    ");
				System.out.println(" |  \\ | /  ");
				System.out.println(" |    |    ");
				System.out.println("___        \n");
			}
			if(guesses == 5)
			{
				System.out.println(" ______    ");
				System.out.println(" |    |    ");
				System.out.println(" |    o    ");
				System.out.println(" |  \\ | /  ");
				System.out.println(" |    |    ");
				System.out.println("___    \\   \n");
			}
			if(guesses == 6)
			{
				System.out.println(" ______    ");
				System.out.println(" |    |    ");
				System.out.println(" |    o    ");
				System.out.println(" |  \\ | /  ");
				System.out.println(" |    |    ");
				System.out.println("___  / \\   \n");
			}
			for(int i = 0; i < answer.length; i++)
			{
				System.out.print(current[i]);
			}
			System.out.println();
			System.out.print("Guessed Letters:");
			Collections.sort(guessed);
			for(int i = 0; i < guessed.size(); i++)
			{
				System.out.print(" " + guessed.get(i));
			}
			System.out.println("\nWrong Guesses: " + guesses);
			System.out.println();
			boolean won = true;
			for(int i = 0; i < current.length; i++)
			{
				if(current[i] == '_')
				{
					won = false;
				}
			}
			if(won)
			{
				break;
			}	
		}
		scan.close();
		if(guesses < 6)
		{
			System.out.println("Congratulations! You won!");
		}
		else
		{
			System.out.print("Oh Well! The answer is ");
			for(int i = 0; i < answer.length; i++)
			{
				System.out.print(answer[i]);
			}
		}
	}

}
