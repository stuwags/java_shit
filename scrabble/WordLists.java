/******************************
*  WordLists.java
*  written by Stuart Wagner
*  
********************************/

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

//how does toArray work?

public class WordLists
{
	private File inFile; private String[] dictionary;//my instance variables
	
	//constructor makes reads a file with filename and initializes it, and runs make dictionary
	public WordLists(String fileName) throws FileNotFoundException
	{
		inFile = new File(fileName);
		makeDictionary();
	}
	
	//This method creates the dictionary by reading each word,
	//adding it to an array list, and then turning it to an array
	private void makeDictionary() throws FileNotFoundException
	{
		ArrayList<String> tempDictionary = new ArrayList<String>();
		Scanner input = new Scanner(inFile);
		while(input.hasNextLine())
		{
			tempDictionary.add(input.next());
		}
		dictionary = tempDictionary.toArray(new String[tempDictionary.size()]);
	}
	
	//this is my print method with returns the arraylist it prints to the output filename
	public ArrayList<String> printTxt(ArrayList<String> outputArray, String output_filename) throws FileNotFoundException
	{
		PrintWriter output = new PrintWriter(output_filename);
		for (String word : outputArray)
		{
			output.println(word);
		}
		output.close();
		return outputArray;
	}
	
	//looks for words with length N and returns an ArrayList of them
	public ArrayList<String> lengthN(int n)
	{
		ArrayList<String> outputArray = new ArrayList<String>();
		for (String word : dictionary)
		{
			if (word.length() == n)
			{
				outputArray.add(word);
			}
		}
		return outputArray;
	}
	
	//looks for words starting witha letter with a specific length 
	public ArrayList<String> startsWith(int n, char firstLetter)
	{
		ArrayList<String> outputArray = new ArrayList<String>();
		for (String word : dictionary)
		{
			if (word.length() == n && word.charAt(0) == Character.toLowerCase(firstLetter))
			{
				outputArray.add(word);
			}
		}
		return outputArray;
	}
	
	//returns an array of words of length n containing the letter included but not beginning with it.
	public ArrayList<String> containsLetter(int n, char included)
	{	
		ArrayList<String> outputArray = new ArrayList<String>();
		for (String word : dictionary)
		{
			for (int character = 1; character <= word.length()-1; character++)
			{
				boolean already_added = false;
				if (word.length() == n && word.charAt(0) != Character.toLowerCase(included) && 
						word.charAt(character) == Character.toLowerCase(included) 
						&& already_added == false)
				{
					outputArray.add(word);
					already_added = true;
				}
			}
		}
		return outputArray;
	}
	
	//returns an array of words of length n containing at least m vowels.
	public ArrayList<String> vowelHeavy(int n, int m)
	{
		char[] vowels = {'a', 'e', 'i', 'o', 'u'};
		ArrayList<String> outputArray = new ArrayList<String>();
		for (String word : dictionary)
		{
			int vowel_count = 0;
			if (word.length() == n) //if it's not the right length, it won't enter the loop and check chars
			{
				for (int character = 0; character <= word.length()-1; character++)
				{
					for (char vowel : vowels)
					{
						if (word.charAt(character) == vowel)
							vowel_count++;
					}
				}
				if (vowel_count >= m)
					{
						outputArray.add(word);
					}
			}
		}
		return outputArray;
	}
	
	//returns an arraylist of m Char's or more
	public ArrayList<String> multiLetter(int m, char included)
	{
		ArrayList<String> outputArray = new ArrayList<String>();
		for (String word : dictionary)
		{
			int letter_count = 0;
			for (int character = 0; character <= word.length()-1; character++)
			{
				if (word.charAt(character) == Character.toLowerCase(included))
					letter_count++;
			}
			if (letter_count >= m)
			{
				outputArray.add(word);
			}
		}
		return outputArray;
	}
	
	//returns an arraylist of words containing one or more of in and alsoIn
	public ArrayList<String> containsTwo(int n, char in, char alsoIn) 
	{
		ArrayList<String> outputArray = new ArrayList<String>();
		for (String word : dictionary)
		{
			//if it's not the right length, it won't enter the loop and check chars
			if (word.length() == n) 
			{
				boolean found_in = false; boolean found_alsoIn = false;
				for (int character = 0; character <= word.length()-1; character++)
				{
						if (word.charAt(character) == Character.toLowerCase(in))
						{
							found_in = true;
						}
						if (word.charAt(character) == Character.toLowerCase(alsoIn))
						{
							found_alsoIn = true;
						}
				}
				if (found_alsoIn == true && found_in == true)
				{
					outputArray.add(word);
				}
			}
		}
		return outputArray;		
	}
	
	//returns all words of length n including letter in but not letter out
	public ArrayList<String> yesAndNo(int n, char in, char out) 
	{
		ArrayList<String> outputArray = new ArrayList<String>();
		for (String word : dictionary)
		{
			//if it's not the right length, it won't enter the loop and check chars
			if (word.length() == n) 
			{
				boolean found_in = false; boolean found_out = false;
				for (int character = 0; character <= word.length()-1; character++)
				{
						if (word.charAt(character) == Character.toLowerCase(in))
						{
							found_in = true;
						}
						if (word.charAt(character) == Character.toLowerCase(out))
						{
							found_out = true;
						}
				}
				if (found_out == false && found_in == true)
				{
					outputArray.add(word);
				}
			}
		}
		return outputArray;	
	}
}
