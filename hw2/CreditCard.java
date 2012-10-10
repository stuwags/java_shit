//****************************************
//
//   CreditCard.java
//
//  This class models a CreditCard number 
//  and provides verification methods on it
//
//  from Stuart Wagner
//
//*****************************************

public class CreditCard 
{

  //initilize credit card
  String full_cc_number;

  //initialize integers for the first two parts of the tests
  int eighth_d, seventh_d, sixth_d, fifth_d, fourth_d, third_d, second_d, first_d;
  int first_check, second_check;

  //create integers for the third part of the test and run the algorithm 
  int third_check, zero_test, check_digit;

  //This method runs at the creation of the credit card and 
  //sets the parameter to the instance variable
  public CreditCard(String full_cc_number)
  {
    this.full_cc_number = full_cc_number;
  }
  
  //This public method runs three private methods involved with verifying a CC number
  public boolean verify()
  {  
    verifySet();
    verifyMath();
    return verifyAlgorithm();
  }

  //Sets each credit card string digit and stores as integers
  private void verifySet()
  {
    second_d = Integer.parseInt(full_cc_number.substring(1, 2)); 
    fourth_d = Integer.parseInt(full_cc_number.substring(3, 4)); 
    sixth_d = Integer.parseInt(full_cc_number.substring(5, 6)); 
    eighth_d = Integer.parseInt(full_cc_number.substring(7, 8));
    first_d = Integer.parseInt(full_cc_number.substring(1, 2)); 
    third_d = Integer.parseInt(full_cc_number.substring(3, 4)); 
    fifth_d = Integer.parseInt(full_cc_number.substring(5, 6)); 
    seventh_d = Integer.parseInt(full_cc_number.substring(7, 8));
  }

  //This runs the primary computation needed to check the CC number
  private void verifyMath()
  {
    //begin first check by summing 2nd, 4th, 6th, and 8th digits
    first_check = second_d + fourth_d + sixth_d + eighth_d;

    //begin second check by doubling 1st, 3rd, 5th, and 7th digits and summing them
    second_check = (first_d * 2) + (third_d * 2) + (fifth_d * 2) + (seventh_d * 2);

    //begin third check and get the last digit of the sum
    third_check = first_check + second_check;
    zero_test = third_check % 10; //this is the digit we need to test against zero.
  }

  //this determines if the CC is legit, and if not, it runs fixCheckDigit
  private boolean verifyAlgorithm()
  { 
    if (zero_test == 0)//checks to verify legit CC
    {
      return true;
    }
    else //this determines a better digit and we return false
    {
      fixCheckDigit();
      return false;
    }  //end algorithm
  }

  //this method finds the number necessary to fix the check digit
  private void fixCheckDigit()
  { 
    //this checks if there is enough space to increase the last digit 
    //to kill the remainder
    if (eighth_d + zero_test < 10) 
    {
      //this adds to the last digit to kill remainder
      check_digit = (10 - zero_test) + eighth_d;
    }
    else
    {
      //this reduces the last digit to kill the remainder
      check_digit =  eighth_d - zero_test;
    }
  }

  //returns the correct digit 
  public int betterDigit()
  {
    return check_digit;
  }
} //end of the class