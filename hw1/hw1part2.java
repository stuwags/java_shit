// ******************************************
// Money Converter Program
// written by Stuart Wagner
// sbw2128
// prints a conversion from money (in cents) to number of dollars and coins needed
// **********************************************************************************


import java.util.Scanner;

public class hw1part2
{

  public static void main(String[] args)
  {
    // make a scanner called input
    Scanner input = new Scanner(System.in);
    System.out.println("Your name please");
    String name = input.nextLine();

    // get a number from the user
    System.out.println("Give me the amount of money in cents please, " + name);
    int money = input.nextInt();
    
    // limit the size of the number
    while(money>100000000)
    {
	System.out.println("This number is too big.");
	System.out.println("Please enter something smaller");
	money = input.nextInt();
    }
    
    // do the calculations

    int hundreds = money / 10000;
    int leftover = money % 10000;

    int fifties = leftover / 5000;
    leftover = leftover % 5000;

    int twenties = leftover / 2000;
    leftover = leftover % 2000;

    int tens = leftover / 1000;
    leftover = leftover % 1000;

    int fives = leftover / 500;
    leftover = leftover % 500;

    int ones = leftover / 100;
    leftover = leftover % 100;

    int quarters = leftover / 25;
    leftover = leftover % 25;

    int dimes = leftover / 10;
    leftover = leftover % 10;

    int nickels = leftover / 5;
    leftover = leftover % 5;

    int pennies = leftover / 1;

    // print the results
    System.out.println(""); System.out.println(""); //formating for results

    System.out.println("******Dollar Bills******"); //This is printout of dollar bills 
    System.out.print(hundreds + " Hundred dollar bill(s), ");
    System.out.print(fifties + " Fifty dollar bill(s), ");
    System.out.print(twenties + " Twenty dollar bill(s), ");  
    System.out.print(tens + " Ten dollar bill(s), ");
    System.out.print(fives + " Five dollar bill(s), ");
    System.out.print(ones + " One dollar bill(s)");
    
    System.out.println(""); System.out.println("");   

    System.out.println("******Coins******"); //This will printout coins 
    System.out.print(quarters + " Quarter(s), ");
    System.out.print(dimes + " Dime(s), ");
    System.out.print(nickels + " Nickel(s), ");
    System.out.print(pennies + " Penny(s)");

    System.out.println(""); //formating for results2

  } // end of the main method

}// end of the class
