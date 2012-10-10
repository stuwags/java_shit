//****************************************

  ReadMe for CCTest.java & CreditCard.java

  The CCTest.java and CreditCard.java files
  serve respectively as the main method and 
  CreditCard Class in the program. Here is
  how the program works. 1) The main method begins
  by initilizing variables and the scanner,
  and getting the credit card number. If the 
  number is not 8 digits long, it repeats until
  an 8 digit number is put in. We were advised 
  that validating by length was reasonable. 
  Upon getting the credit card number, the program
  instantiates a new credit card by passing the 
  number to the new object. From there, the program 
  runs a public method called verify (which has a 
  series of private methods run within it) to 
  determine if the card is valid or not. If it is 
  not valid, the program provides a new check digit.

  From a user's perspective, the user is required to
  enter an 8 digit number, and then is either told 
  if it is valid or what the check digit must be to make
  the 8 digit number valid. 

  from Stuart Wagner
*****************************************

  ReadMe for ExpApproximatorTester.java
  & ExpApproximator.java

  These two files serve respectively as the main method 
  and ExpApproximator Class in the program. Here is
  how the program works. 1) The main method begins
  by initilizing the scanner,and getting number for 
  xpower and epsilon. This describes the tolerance level 
  and the input into the Exponent Approximator function.
  The user is prompted to enter values for xpower and epsilon.   
  From there, the program instantiates an ExpApproximator
  object and passes epsilon and xpower in. 
  
  The program gets a bit more technical here. In order to
  list all guesses (translation is number of times the 
  function runs), I'm required to show a hardcoded value. 
  The reason for this is because dividing 1 by 0factorial
  is equal to one, however we were advised to just hardcode 
  1 in. This is interesting, because although the first 
  calculation in the program is not at line 35, the first 
  calculation of the actual formala is actually valued at 
  one and is displayed by line 35. 

  Once we enter the loop at line 38, the program continually
  loops until the method hasMoreGuesses turns false. While true,
  the program continues to engage in more guesses/calculations
  with values that decrease with each iteration. These values 
  are added to sum. 

  From a user's perspective, they must enter a value for 
  xpower and epsilon. After that, they are given the resulting
  calculation after the mathmatical function is run each time
  until the result of the function is smaller than epsilon. Then,
  the sum of all the calculations (including the hard coded value)
  are printed out. 

  from Stuart Wagner
*****************************************