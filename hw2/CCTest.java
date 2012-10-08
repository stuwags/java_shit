/******************************
*  CCTest.java
*  written by Stuart Wagner
*  
*  Main Method
********************************/

import java.util.Scanner;

public class CCTest{

  public static void main(String[] args)
  {
    String full_cc_number = "0";//storage variable for credit card number

    //initialize scanner
    Scanner input = new Scanner(System.in);

    //get the credit card number and checks if it is 8 digit. If not, it loops
    System.out.println("What is your credit card number(8 digits please)?");
    while (full_cc_number.length() != 8)
    {
      full_cc_number = input.nextLine();
      if (full_cc_number.length() != 8)
      {
        System.out.println("That wasn't an 8 digit number. Please try again.");
      }
    }

    //make a new credit card object and pass in the string in a parameter
    CreditCard myCard = new CreditCard(full_cc_number);

    //runs tests to ensure digits are all proper
    //if they aren't proper, return proper digit
    //this then prints out what the method returns
    if (myCard.verify() == true)
    {
      System.out.println("Congrats! Card is valid");
    }
    else
    {
      System.out.println("Card is not valid.");
      System.out.println("To validate, the new check digit must be " + myCard.betterDigit());
    }
  }
}//end class