// GrossPay Program
// Stuart Wagner
// sbw2128
// ***********************

import java.util.Scanner;

public class hw1part1      
{

  public static void main(String[] args)
  {

    Scanner input = new Scanner(System.in);

    //get the name
    System.out.println("What is your name?");
    String name = input.nextLine();

    String response = "Yes"; //get the loop to start

    while ((response.equals("Yes")) || (response.equals("yes")))
    {
      //initialize instance variables I will need in if statements
      double extraPay1;
      double extraPay2;
      int hours;

      //create set values for instance variables I'll need 
      System.out.println("How many hours did you work this week, " + name + "?");
      hours = input.nextInt(); //we use int here because no credit for partial hours

      while (hours > 168) //If user enters hours larger than possible, they must enter an int smaller than 168
      {
        System.out.println("You lie, you lying liar! There are not that many hours in a week. Enter hours again and stop trying to cheat!");
        System.out.println("How many hours did you work this week, " + name + "?");
        hours = input.nextInt(); //we use int here because no credit for partial hours
      }
      
      System.out.println("What is your standard pay rate, " + name + "?");
      double rate = input.nextDouble();

      //initialize and set values for instance variables I'll need 
      double grossPay = 0; //needed to set this to 0 in order to get program to compile
      int extraHours = hours - 40;
      double standardPay = 40 * rate;
      double rate1 = rate * 1.5; //rate when 40-54 hours
      double rate2 = rate * 2; //rate when above 54 hours
      extraPay1 = 14 * rate1;

      if (hours <= 168) //this allows all possible outcomes in a week
      {
        //if hours worked is less than 40
        if (hours <= 40)
        {
          grossPay = hours * rate;
        }

        //if hours worked is between 40 and 54
        if (extraHours > 0 && extraHours <= 14)
        {
          extraPay1 = extraHours * rate1;
          grossPay = standardPay + extraPay1;
        }

        //if hours worked is above 54
        if (extraHours > 14)
        {
          extraPay2 = (extraHours - 14) * rate2;
          grossPay = standardPay + extraPay1 + extraPay2;
        }
      }

      //give the user the answers
      System.out.println("Your grosspay is $" + grossPay);

      //this allows loop to repeat
      System.out.println(name + ", would you like to run this program again? Please input \"Yes\" or \"No\"");
      response = input.next();
    }
    System.out.println("Thanks for playing!");   
  }
}