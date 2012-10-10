
/******************************
*  ExpApproximatorTester.java
*  written by Stuart Wagner
*  
*  Main Method
********************************/

import java.util.Scanner;

public class ExpApproximatorTester
{

  public static void main(String[] args)
  {

    //initialize scanner
    Scanner input = new Scanner(System.in);

    //get the Xpower
    System.out.println("What number would you like to use for X in E^x?");
    final double xpower = input.nextDouble();

    //get the Tolerance called epsilon
    System.out.println("What level of accuracy would you like?");
    final double epsilon = input.nextDouble();

    //create an instance of ExpApproximator and pass in epsilon and x
    ExpApproximator approx = new ExpApproximator(epsilon, xpower);

    //set the loop
    int i = 1;
    
    //print the first guess, which was set to be 1
    System.out.println(approx.sum() + " is guess number " + i + "(this was hardcoded per TA instructions as 1)");
    
    //print all the remaining guesses until the epsilon threshold is reached
    while (approx.hasMoreGuesses())
    {
      i++;
      System.out.println(approx.nextGuess() + " is guess number " + i);
    }

    //print out the final sum of all guesses
    System.out.println(approx.sum() + " is the sum of all the guesses");
  }
}