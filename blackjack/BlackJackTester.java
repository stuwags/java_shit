/******************************
*  BlackJackTester.java
*  written by Stuart Wagner
*  
*  Main Method
********************************/
import java.util.Scanner; 

public class BlackJackTester {

	public static void main(String[] args) 
	{
	    Scanner input = new Scanner(System.in);
	    int again = 1;
	    while (again == 1)
	    {
	    	Game game = new Game();

	    	System.out.println("Do you want to play another game of blackjack - (1 for yes and 2 for no)");
		    again = input.nextInt();
	    }
	}
}
