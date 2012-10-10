/*********************************
*  ExpApproximatorTester.java
*  written by Stuart Wagner
*
*  solution to P6.12 in Big Java
*
*********************************/



public class ExpApproximator{  
//create the class

    //initialize variables and set sum = 0
    private double term, epsilon, xpower, sum = 0;
    private int n = 1;

    //this block runs when the class is instantiated
    public ExpApproximator(double epsilon, double xpower)
    {
        this.epsilon = epsilon; this.xpower = xpower;   
        term = 1.0; //this is the first term, starting with 0 in the series
        sum = term; //setting sum to the first term, starting at 1
    }

    //method that determines if there should be more guesses based
    //on term being greater than level of accuracy desired
    public boolean hasMoreGuesses()
    {
        return (term > epsilon);
    }

    //nextGuess runs the ExpApproximator for another iteration
    //and adds the guess to the variable sum
    public double nextGuess(){
        term = term * (xpower / n);
        sum = sum + term;
        n++;
        return term;
    }

    //this is a getter for sum
    public double sum()
    {
        return sum;
    }
} // end of class