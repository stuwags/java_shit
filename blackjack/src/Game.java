import java.util.Scanner; 

public class Game 
{
	Deck deck; Player p1; Dealer d1; int dh1_score; int ph1_score; int ph2_score; float bet; int again;
	float starting_money; boolean legit_value;
    Scanner input = new Scanner(System.in);
    
	public Game()
	{
		startDaGame();
		again = 1;
		while (again == 1)
		{
			playDaGame();
			p1.gambleReturns(bet);
			System.out.println("Play another hand - 1 for yes and any other int for no?");
			again = input.nextInt();
			if (again == 1)
				resetAndShuffle();
		}
	}
	
	private void dealPlayerAndDealer()
	{
    	Card[] two_cards = d1.dealPlayerHand();
		for (int i = 0; i < 2; i++)
    	{
    		p1.getHand(1).addCard(two_cards[i]);
    	}
		d1.dealDealerHand();
	}
	
	private void printHiddenHands()
	{
		System.out.print("The dealer's show card is the ");
		d1.printHiddenHand();
		System.out.println("***********************************************************");
		System.out.print("Your hand includes: ");
		p1.printHand(1);
	}
	
	private void playerHitLoop()
	{
    	System.out.print("Do you want to hit? (1 for yes, 2 for no)\n");
    	int hit = input.nextInt();
    	while (hit == 1 && p1.getHand(1).getPoints() <= 21)
    	{
    		Card card = d1.playerHit();
    		p1.getHand(1).addCard(card);
	    	System.out.println("You received a " + card);
	    	System.out.println("The total point score is " + p1.getHand(1).getPoints());
	    	if (p1.getHand(1).getPoints() > 21)
	    	{
	    		System.out.println("You busted, sorry!"); System.out.println("Press any number to continue");
	    		int any = input.nextInt();
	    	}
	    	if (p1.getHand(1).getPoints() == 21)
	    	{
	    		System.out.println("Congrats you got 21!"); System.out.println("Press any number to continue");
	    		int any = input.nextInt();
	    		hit = 2;
	    	}
	    	if (p1.getHand(1).getPoints() < 21)
	    	{
	    		System.out.print("Do you want to hit again? (1 for yes, 2 for no)\n");
	    		hit = input.nextInt();
	    	}
    	}
	}
	
	private void dealerHitLoop()
	{
    	System.out.println("***********************************************************");
    	System.out.print("The Dealers current hand is: " + d1.returnDealerHand());
    	while (d1.getHand().getPoints() < 17)
    	{
        	System.out.println("***********************************************************");
    		d1.dealerHit();
    		System.out.println("The dealer's total point score is " + d1.getHand().getPoints() + " points");
	    	if (d1.getHand().getPoints() > 21)
	    	{
	    		System.out.println("Dealer busts!");
	    	}
    	}
	}
	
	private void winLossLogic()
	{
    	dh1_score = d1.getHand().getPoints(); ph1_score = p1.getHand(1).getPoints();
        if (dh1_score > 21 && ph1_score > 21)
        {
			System.out.println("Both player and dealer bust! Player loses money - sorrrrrrry!!!");
			bet = bet * -1;
        }
        else
        {	
        	if (dh1_score == ph1_score)
        	{
        		System.out.println("It's a push!!!!");
        		bet = 0;
	        }
	    	if (dh1_score > ph1_score)
	    	{
	    		if (dh1_score > 21)
	    			System.out.println("Dealer busts, Player wins");
	    		else
	    		{
	    			System.out.println("Dealer wins, Player loses");
	    			bet = bet * -1;
	    		}
	    	}
	    	if (dh1_score < ph1_score)
	    	{
	    		if (ph1_score > 21)
	    		{
	    			System.out.println("Player busts, Dealer Wins");
	    			bet = bet * -1;
	    		}
	    		else
	    			System.out.println("Player wins");
	    	}
        }
	
	private void startDaGame()
	{
		System.out.println("How much money do you want to buyin? - enter 100.00 to 100,000 in a" +
		" multiple of 10");
		starting_money = input.nextFloat();
		//add validations to the money size and remove commas	    
		legit_value = false;
		buyIn();
		deck = new Deck();
		p1 = new Player(starting_money); 
		d1 = new Dealer(deck);
	}
	
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
	
	private void doubleDown()
	{
		if (d1.getHand().getPoints() < 21 && p1.returnMoney() >= bet*2)
		{
			System.out.println("Do you want to double down? - 1 for yes and 2 for no");
	   		int double_down = input.nextInt();
	   		if (double_down == 1)
	   		{
	   			bet = bet*2;
	   			System.out.println("Your bet is now $" + bet);
	   		}
		}
	}
	
	private void placeYourBet()
	{
		System.out.println("You currently have $" + p1.returnMoney() + " of chips");
		System.out.println("How much money do you want to bet on this hand? - enter 10.00 to" +
		" 1000.00 in a multiple of 10");
		bet = input.nextFloat();
		legit_value = false;
		while (legit_value == false)
		{
			if (bet % 10 != 0 || bet < 10 || bet > 1000)
			{
				System.out.println("Get it right Stupid: How much money do you want to bet on " + 
						"this hand? - enter 10.00 to 1000.00 in a multiple of 10");
				bet = input.nextFloat();
			}
			else
			{
				legit_value = true;
				System.out.println("You have bet $" + bet + " of chips" + "\nGood Luck!");
			}
		}
	}
	
	private void earlyBlackJackCheck()
	{
		if (d1.returnDealerHand().getPoints() == 21)
		{
			if (p1.getHand(1).getPoints() == 21)
			{
				System.out.println("Both player and dealer got blackjack and push!");
				System.out.println("Dealer's hand is " + d1.returnDealerHand());
				System.out.println("your hand is " + p1.getHand(1));
				bet = 0;
			}
			else
			{
				System.out.println("Dealer has blackjack and wins");
				System.out.println("Dealer's hand is " + d1.returnDealerHand());
				System.out.println("your hand is " + p1.getHand(1));
				bet = bet * -1;
			}
		}
		if (p1.getHand(1).getPoints() == 21)
		{
			System.out.println("Player got BlackJack and Computer did not!");
			bet = bet * 1.5f;
		}
	}
	
	private void playDaGame()
	{
		placeYourBet();
		dealPlayerAndDealer();
		earlyBlackJackCheck();
		printHiddenHands();
	    doubleDown();	
	    playerHitLoop();
	    dealerHitLoop();
	    System.out.println("The Dealer got " + d1.getHand().getPoints() + " points");
	    System.out.println("The Player got " + p1.getHand(1).getPoints() + " points");
	    winLossLogic();
	}
	
	private void resetAndShuffle()
	{
		p1.getHand(1).resetHand(); p1.getHand(2).resetHand(); d1.getHand().resetHand();
		if (deck.getDeckLoc() > 40)
			deck.shuffle();
	}
}