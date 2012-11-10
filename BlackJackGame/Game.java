/******************************
*  Game.java
*  written by Stuart Wagner

********************************/

import java.util.Scanner; 

public class Game 
{
	//instance variables include deck, player and ealer, bets, 
	//again value, starting money, legit value, and scanner
	
	private Deck deck; private Player p1; private Dealer d1;
	private float bet; private float bet2; private int again;
	private float starting_money; private boolean legit_value; 
    Scanner input = new Scanner(System.in);
    
    //constructor runs a number of things all surrounding the game
	public Game()
	{
		startTheGame();
		again = 1;
		while (again == 1)
		{
			playTheGame();//all methods referring to playing
			returnChipsToPlayer();
			if (p1.returnMoney() == 0)//if you are out of chips
			{
				System.out.println("You are out of chips! You may start a new game and buyin again!");
				again = 0;
			}
			else
			{
				System.out.println("Play another hand - 1 for yes and any other int for no?");
				again = input.nextInt();
			}
			if (again == 1)
				resetAndShuffle();
		}
	}
	
	private void returnChipsToPlayer() //returns score to player after adjusting for two hands if necessary
	{
		if (p1.numberOfHands() > 1)
		{
			if (p1.numberOfHands() > 1)
			{
			System.out.println("Hand 1 bet returns: " + bet); 
			System.out.println("hand 2 bet returns: " + bet2);
			}
			{bet = bet + bet2;}
		}
		p1.gambleReturns(bet);
	}
	
	//this is a special method with commented out developer tools. If you want to use
	//these developer tools with the hand dev tools, uncomment them.
	//They allow you to deal cards of your choice to the dealer and/or player
	//this allowed me to create tests for cases such as blackjack for dealer or player
	//or creating splits
	private void dealPlayerAndDealer()
	{
    	Card[] two_cards = d1.dealPlayerHand();
		for (int i = 0; i < 2; i++)
    	{
    		p1.getHand(1).addCard(two_cards[i]);
    	}
		d1.dealDealerHand();
//		p1.getHand(1).devDealPlayer();
//		d1.returnDealerHand().devDealDealer();

	}
	
	//This prints out the player hand with Dealer show card
	private void printHiddenHands()
	{
		System.out.print("The dealer's show card is the ");
		d1.printHiddenHand();
		System.out.println("***********************************************************");
		System.out.print("Your hand includes: ");
		p1.printHand(1);
	}
	
	//This loop is to allow the player to hit when appropriate, and will run for as many
	//iterations as there are hands
	private void playerHitLoop(int game_iterations)
	{
		int hit = 0;
		if (p1.getHand(game_iterations).getPoints() < 21 || d1.returnDealerHand().blackJackCheck() == false)
			{
			System.out.print("Do you want to hit? (1 for yes, 2 for no) for hand " + game_iterations+ "\n");
			hit = input.nextInt();
			}
		while (hit == 1 && p1.getHand(game_iterations).getPoints() <= 21)
    	{
    		Card card = d1.playerHit();
    		p1.getHand(game_iterations).addCard(card);
	    	System.out.println("You received a " + card);
	    	System.out.println("The total point score is " + p1.getHand(game_iterations).getPoints());
	    	if (p1.getHand(game_iterations).getPoints() > 21)
	    	{
	    		System.out.println("You busted, on hand " + game_iterations + " sorry!");
	    	}
	    	else if (p1.getHand(game_iterations).getPoints() == 21)
	    	{
	    		System.out.println("Congrats you got 21 on hand" + game_iterations + "!");
	    		hit = 2;
	    	}
	    	else 
	    	{
	    		System.out.print("Do you want to hit? (1 for yes, 2 for no) for hand " + game_iterations+ "\n");
				hit = input.nextInt();
	    	}
    	}
	}
	
	//This loop is to allow the dealer to hit when appropriate
	private void dealerHitLoop()
	{
		if (p1.numberOfHands() > 1 && p1.getHand(1).getPoints() > 21 
				&& p1.getHand(2).getPoints() > 21)	
		{
			System.out.println("Dealer stays as player has busted in both hands");
		}
		else if (p1.numberOfHands() > 1 && p1.getHand(1).blackJackCheck() == true 
				&& p1.getHand(2).blackJackCheck() == true)
		{
			System.out.println("Dealer doesn't hit as player got double blackjack");
		}
		else if (p1.getHand(1).getPoints() > 21 && p1.numberOfHands() < 2)
    	{
    		System.out.println("Dealer stays as player has busted");
    	}
    	else if (p1.getHand(p1.numberOfHands()).blackJackCheck() && p1.numberOfHands() < 2)
    	{
    		System.out.println("Player wins with blackjack! Dealer loses his turn!");
    	}
    	else
    	{
			System.out.println("***********************************************************");
	    	System.out.print("The Dealers current hand is: " + d1.returnDealerHand());
		    while (d1.returnDealerHand().getPoints() < 17 )
		    {
		    	System.out.println("***********************************************************");
		    	d1.dealerHit();
		    	System.out.println("The dealer's total point score is " + d1.returnDealerHand().getPoints() + " points");
			   	if (d1.returnDealerHand().getPoints() > 21)
			   	{
			   		System.out.println("Dealer busts!");
			   	}
		    }
    	}
	}
	
	//This runs the winLossLogic after both players have hit. This does not account for early black jack, which is handled
	//by another method
	private void winLossLogic(int game_iteration)
	{
		System.out.print("*********************************************************");
		System.out.print("\nResult: ");
		int dh1_score = d1.returnDealerHand().getPoints(); int ph_score = p1.getHand(game_iteration).getPoints();
		String hand = "";
		if (p1.numberOfHands() > 1)
		{
	        hand = " for hand " + game_iteration;
		}
		if (dh1_score == ph_score && dh1_score <= 21)
        {
        	System.out.println("It's a push" + hand + "!!!");
        	betLogic(game_iteration, 0);
        }
        else if (dh1_score > ph_score)
	    {
	    	if (dh1_score > 21)
	    		System.out.println("Dealer busts, Player wins" + hand);
	    	else
	    	{
	    		System.out.println("Dealer wins, Player loses" + hand);
	        	betLogic(game_iteration, -1);
	    	}
	    }
        else if (dh1_score < ph_score)
	    {
	    	if (ph_score > 21)
	    	{
	    		System.out.println("Player busts, Dealer Wins" + hand);
	        	betLogic(game_iteration, -1);
	    	}
	    	else
	    		System.out.println("Player wins" + hand);
	    }
	}
	
	//this runs bet logic for each hand and amount
	private void betLogic(int which_hand, float amount)
	{
		if (which_hand == 1)
			bet = bet * amount;
		else
			bet2 = bet2 * amount;
	}
	
	//This starts the game by getting the buyin, and creating a deck, player, and dealer
	private void startTheGame()
	{
		System.out.println("How much money do you want to buyin? - enter 100.00 to 100,000 in a" +
		" multiple of 10");
		starting_money = input.nextFloat();	    
		legit_value = false;
		buyIn();
		deck = new Deck();
		p1 = new Player(starting_money); 
		d1 = new Dealer(deck);
	}
	
	//This runs to get a legitimate value for buyin
	private void buyIn()
	{
		while (legit_value == false)
		{
			if (starting_money % 10 != 0 || starting_money < 100 || starting_money > 100000)
			{
				System.out.println("Get it right Stupid: How much money do you buyin?" +
					" - enter 100 to 100,000 in a multiple of 10");
				starting_money = input.nextFloat();
			}
			else
			{
				legit_value = true;
				System.out.println("You have bought in with $" + starting_money + " of chips");
			}
	
		}
	}
	//This allows for doubling down
	private boolean doubleDown()
	{
		int d1_score = d1.returnDealerHand().getPoints(); int p1_score = p1.getHand(1).getPoints();
		if (p1.returnMoney() >= bet*2 && d1_score < 21 && p1_score < 21)
			{
				System.out.println("Do you want to double down? - 1 for yes and 2 for no. " +
						"You will receive only 1 card after this.");
	   			int double_down = input.nextInt();
		   		if (double_down == 1)
		   		{
		   			bet = bet*2;
		   			System.out.println("Your bet is now $" + bet);
		   			p1.getHand(1).addCard(d1.playerHit());
		   			System.out.println("Your new hand is " + p1.getHand(1));
		   			return true;
		   		}
		   		else 
		   			return false;
			}
   		else
   		{
   			return false;
   		}
	}
	
	//This creates the bet and provides validations for it
	private void placeYourBet()
	{
		System.out.println("You currently have $" + p1.returnMoney() + " of chips");
		System.out.println("How much money do you want to bet on this hand? - enter 10.00 to" +
		" 1000.00");
		bet = input.nextFloat();
		legit_value = false;
		while (legit_value == false)
		{
			if (bet < 10 || bet > 1000 || bet > p1.returnMoney())
			{
				System.out.println("Get it right Stupid: How much money do you want to bet on " + 
						"this hand? - And don't " +
						"bet more than you have chips");
				bet = input.nextFloat();
			}
			else
			{
				legit_value = true;
				System.out.println("You have bet $" + bet + " of chips" + "\nGood Luck!");
			}
		}
	}
	
	//runs an early check for blackjack and manages bets based on that
	private void earlyBlackJackCheck(int game_iterations)
	{
		d1.returnDealerHand().blackJackCheck();
		d1.returnDealerHand();
		if (d1.returnDealerHand().blackJackCheck() == true && p1.getHand(p1.numberOfHands()).blackJackCheck() == true)
		{
			System.out.println("Both player and dealer got blackjack and push!");
			System.out.println("Dealer's hand is " + d1.returnDealerHand());
			System.out.println("Your hand is " + p1.getHand(p1.numberOfHands()));
			betLogic(game_iterations, 0);
		}
		else if (d1.returnDealerHand().blackJackCheck() == true)
		{
			System.out.println("Dealer has blackjack and wins");
			System.out.println("Dealer's hand is " + d1.returnDealerHand());
			System.out.println("Your hand is " + p1.getHand(p1.numberOfHands()));
			betLogic(game_iterations, -1);
		}
		else if (p1.getHand(game_iterations).blackJackCheck() == true)
		{
			System.out.println("Player got BlackJack for hand " + game_iterations);
			betLogic(game_iterations, 1.5f);
		}
	}
	
	//determines if a player can and decides to split their hand
	private void splitCheck()
	{
		if (p1.getHand(1).splitCheck() == true && p1.returnMoney() >= bet * 2)
		{
			System.out.println("Do you want to split your hand - 1 for yes and 2 for no!");
			int response = input.nextInt();
			if (response == 1)
			{
				split();
			}
		}
	}
	
	//This splits the hand and activities the appropriate methods to make split happen
	private void split()
	{
		Card transfer_card = p1.getHand(1).split(d1.playerHit());
		p1.split(transfer_card);
		bet2 = bet;
		System.out.println("Hand has been split to two hands - Hand1 bet = " + bet + " Hand2 bet = " + bet2);
		p1.getHand(1).addCard(d1.playerHit());p1.getHand(2).addCard(d1.playerHit());
		System.out.println("Your hands are printed below. The hit loop will start with the first hand");
		System.out.println("****************************************************************************************");

		System.out.println("Hand 1 => " + p1.getHand(1));
		System.out.println("Hand 2 => " + p1.getHand(2));
	}
	
	//This runs all the methods for playing a game
	private void playTheGame()
	{
		placeYourBet();
		dealPlayerAndDealer();
		earlyBlackJackCheck(1);
		if (d1.returnDealerHand().blackJackCheck() == false && p1.getHand(1).blackJackCheck() == false)
		{
			printHiddenHands();
		    if (doubleDown() != true)
		    {
		    	splitCheck();
				for (int game_iterations = 1; game_iterations <= p1.numberOfHands(); game_iterations++)
				{
				    if (p1.numberOfHands() > 1)
				    {
				    	earlyBlackJackCheck(game_iterations);
				    }
				    if (p1.getHand(game_iterations).blackJackCheck() == false)
				    {
				    	System.out.print("Hit or stay for hand " + game_iterations + " => ");
				    	System.out.print(p1.getHand(game_iterations));
				    	playerHitLoop(game_iterations);
				    }
				}
		    }
			System.out.print("Press any key to watch the dealer's turn go!");
	    	String any = input.next();
			dealerHitLoop();
			printTheResults();
			for (int game_iterations = p1.numberOfHands(); game_iterations > 0; game_iterations--)
			{
				if (p1.getHand(game_iterations).blackJackCheck() == false)
					winLossLogic(game_iterations);
			}
		}
	}
	//resets and shuffles game
	private void resetAndShuffle()
	{
		if (p1.numberOfHands() > 1)
		{
			p1.getHand(2).resetHand(); p1.resetNumberOfHands(); bet2 = 0;
		}
		p1.getHand(1).resetHand(); d1.returnDealerHand().resetHand();
		if (deck.getDeckLoc() > 40)
			deck.shuffle();
	}
	//prints results for each hand
	private void printTheResults()
	{
	    System.out.println("The Dealer got " + d1.returnDealerHand().getPoints() + " points");
		String hand = "";
		if (p1.numberOfHands() > 1)
		{
			for (int i = 1; i <= 2; i++)
			{
				hand = " for hand " + i;
				System.out.println("The Player got " + p1.getHand(i).getPoints() + " points" + hand );
			}
		}
	}
}