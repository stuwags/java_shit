/******************************
*  WordListsTest.java
*  written by Stuart Wagner
*  
********************************/

import java.util.Scanner;
import java.io.*;
import java.util.InputMismatchException;

public class WordListsTest 
{
	public static void main(String[] args) throws Exception
	{	
		//declare some variables at top which I will need
		Scanner input; WordLists wordlist1; int method_select;
		
		try   //try block starts
		{
		    input = new Scanner(System.in);
		    
		    //instantiate new wordlist with name of args of 0
		    wordlist1 = new WordLists(args[0]);
		    
		    //this makes the program read args[1] early in the program to 
		    //make it error out at the beginning of the program. Otherwise, it would only
		    //let the user know they entered or didn't enter good args too late
		    String make_args_called_at_beginning = args[1];
	    	
	    	System.out.println("Welcome to the Scrabble dictionary searcher! " + "\n" +
	    			"If you made it here, you know that the first and second " + "\n" +
	    			"command line arguments are for the name of the file to read " + "\n" +
	    			"and name of the file to write.");
	    	
	    	//loop for the program methods
	    	int again = 1;
	    	while (again == 1)
	    	{
	    		//ran static method print options. Determined after speaking with TA
	    		//to leave the rest of the prints in the main method as it actually is
	    		//more readable this way
	    		printOptions();
		    	
	    		//this allows user to pick the interface and method to run
				method_select = input.nextInt();
		    	if (method_select == 1)
		    	{
		    		//interface for method one
		    		System.out.println("This Length takes the following parameters:(int n)");
		    		System.out.println("Enter the length of words you want!");
		    		int n = input.nextInt();
		    		System.out.println(wordlist1.printTxt(wordlist1.lengthN(n), args[1]) + "\n");
					System.out.println("Congrats, it successfully read from "
							+ args[0] + " and printed your results to the file " + args[1]);
					System.out.println("Do you want to select another method to write to the file?(1 for yes and any other number for no) Note that " + 
							args[1] + " will be overwritten!");
		    	}
		    	
		    	else if (method_select == 2)
		    	{
		    		//interface for method two
		    		System.out.println("This startsWith takes the following parameters:" +
		    				"(int n, char firstLetter)");
		    		System.out.println("Enter the length of words you want!");
		    		int n = input.nextInt();
		    		String first_letter = "wrong";
		    		while (first_letter.length() != 1)
		    		{
		    			System.out.println("What letter do you want it to start with?");
		    			first_letter = input.next();
		    		}
		    		char letter = first_letter.charAt(0);
		    		System.out.println(wordlist1.printTxt(wordlist1.startsWith(n, letter), args[1]));
					System.out.println("Congrats, it successfully read from "
							+ args[0] + " and printed your results to the file " + args[1]);
					System.out.println("Do you want to select another method to write to the file?(1 for yes and any other number for no) Note that " + 
							args[1] + " will be overwritten!");
		    	}
		    	
		    	else if (method_select == 3)
		    	{
		    		//interface for method 3
		    		System.out.println("This containsLetter method takes the following parameters:" +
		    				"(int n, char included)");
		    		
		    		System.out.println("Enter the length of words you want!");
		    		int n = input.nextInt();
		    		String first_letter = "wrong";
		    		while (first_letter.length() != 1)
		    		{
		    			System.out.println("What letter do you want located anywhere in " +
		    					"the word except the first letter?");
		    			first_letter = input.next();
		    		}
		    		char letter = first_letter.charAt(0);
		    		System.out.println(wordlist1.printTxt(wordlist1.containsLetter(n, letter), args[1]));
					System.out.println("Congrats, it successfully read from "
							+ args[0] + " and printed your results to the file " + args[1]);
					System.out.println("Do you want to select another method to write to the file?(1 for yes and any other number for no) Note that " + 
							args[1] + " will be overwritten!");
		
		    	}
		    	
		    	else if (method_select == 4)
		    	{
		    		//interface for method 4
		    		System.out.println("This vowelHeavy method takes the following parameters:(int n, int m)");
			
					System.out.println("Enter the length of words you want!");
					int n = input.nextInt();
					
					System.out.println("Enter the minimum number of vowels you want!");
					int m = input.nextInt();
					
					System.out.println(wordlist1.printTxt(wordlist1.vowelHeavy(n, m), args[1]));
					System.out.println("Congrats, it successfully read from "
							+ args[0] + " and printed your results to the file " + args[1]);
					System.out.println("Do you want to select another method to write to the file?(1 for yes and any other number for no) Note that " + 
							args[1] + " will be overwritten!");
		    	}
		    	
		    	else if (method_select == 5)
		    	{
		    		//interface for method 5
		    		System.out.println("This multiLetter method takes the following parameters:(int m, char included)");
		    		
		    		System.out.println("Enter the number of one specific letter you want in each word!");
		    		int n = input.nextInt();
		    		String first_letter = "wrong";
		    		while (first_letter.length() != 1)
		    		{
		    			System.out.println("What letter do you want ");
		    			first_letter = input.next();
		    		}
		    		char letter = first_letter.charAt(0);
		    		System.out.println(wordlist1.printTxt(wordlist1.multiLetter(n, letter), args[1]));
					System.out.println("Congrats, it successfully read from "
							+ args[0] + " and printed your results to the file " + args[1]);
					System.out.println("Do you want to select another method to write to the file?(1 for yes and any other number for no) Note that " + 
							args[1] + " will be overwritten!");
		    	}
		    	
		    	else if (method_select == 6)
		    	{
		    		//interface for method 6
		    		System.out.println("This containsTwo method takes the following parameters:(int n, char in, char alsoIn)");
		    		
		    		System.out.println("Enter the number of letters you want in each word!");
		    		int n = input.nextInt();
		    		String first_letter = "wrong";
		    		while (first_letter.length() != 1)
		    		{
		    			System.out.println("What letter do you want in?");
		    			first_letter = input.next();
		    		}
		    		char in = first_letter.charAt(0);
		    		
		    		first_letter = "wrong";
		    		while (first_letter.length() != 1)
		    		{
		    			System.out.println("What other letter do you want in?");
		    			first_letter = input.next();
		    		}
		    		char alsoIn = first_letter.charAt(0);
		    		
		    		System.out.println(wordlist1.printTxt(wordlist1.containsTwo(n, in, alsoIn), args[1]));
					System.out.println("Congrats, it successfully read from "
							+ args[0] + " and printed your results to the file " + args[1]);
					System.out.println("Do you want to select another method to write to the file?(1 for yes and any other number for no) Note that " + 
							args[1] + " will be overwritten!");
		    	}
		    	
		    	else if (method_select == 7)
		    	{
		    		//interface for method 7
		    		System.out.println("This  method takes the following parameters:(int n, char in, char out)");
		    		
		    		System.out.println("Enter the number of letters you want in each word!");
		    		int n = input.nextInt();
		    		String first_letter = "wrong";
		    		while (first_letter.length() != 1)
		    		{
		    			System.out.println("What letter do you want in a word?");
		    			first_letter = input.next();
		    		}
		    		char in = first_letter.charAt(0);
		    		
		    		first_letter = "wrong";
		    		while (first_letter.length() != 1)
		    		{
		    			System.out.println("What do you not want in the word?");
		    			first_letter = input.next();
		    		}
		    		char out = first_letter.charAt(0);
		    		System.out.println(wordlist1.printTxt(wordlist1.yesAndNo(n, in, out), args[1]));
					System.out.println("Congrats, it successfully read from "
							+ args[0] + " and printed your results to the file " + args[1]);
					System.out.println("Do you want to select another method to write to the file?\n(1 " +
							"for yes and any other number for no) Note that " + 
							args[1] + " will be overwritten!");
		    	}
		    	
		    	else
		    	{
		    		//if you don't enter an int between one and 7
		    		System.out.println("You must enter a number between 1 and 7.");
		    	}
		    	
		    	//answer if they want to run again
		    	again = input.nextInt();	
	    	}
		}
		//catches bad read file names
    	catch(IOException e)
		{
			System.out.println("Please try again with correct input and output file name");
		}
    	//if I call a command line argument out of bounds (meaning there are not 2 arguments in command
		catch(ArrayIndexOutOfBoundsException e) 
		{
			System.out.println("You entered a bad command line argument. You should enter \n" +
					"the name of two files. The first must exist and be a txt file. The second \n" +
					"will be the one you want created, ideally with a .txt extension stated.");
		}
		//if they enter a character other than a number when asked
		catch(InputMismatchException e) 
		{
			System.out.println("You entered something other than a number, stupid. The program has crashed. " +
					"Restart it!");
		}
		//catch all for any other error that I did not expect or specify
		catch(Exception e)
		{
			System.out.println("Something broke. Try again");
		}
	}
	
	//prints options
	private static void printOptions()
	{
		System.out.println("Please choose a method: " +
	    		"\nPress 1 for the lengthN method(int n)" +
	    		"\nPress 2 for the startsWith method (int n, char firstLetter)" +
	    		"\nPress 3 for the containsLetter method (int n, char included)" +
	    		"\nPress 4 for the vowelHeavy method (int n, int m)" +
	    		"\nPress 5 for the multiLetter method(int m, char included)" +
	    		"\nPress 6 for the containsTwo method(int n, char in, char alsoIn)" +
	    		"\nPress 7 for the yestAndNo method(int n, char in, char out)");
	}
}
