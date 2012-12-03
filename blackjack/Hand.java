/******************************
*  Hand.java
*  written by Stuart Wagner
*  
********************************/
public class Hand 
{
	
	//11 is max hand size in blackjack, because 4 aces and 4 twos and 3 threes make up 21
	//declares a card array named hand, and a pointer called hand_size
	private Card[] hand; private int hand_size;
	
	public Hand() 
	//constructor creates a new Hand array and sets hand size to 0
	{	 
		hand = new Card[11];
		hand_size = 0;
	}
	
	//This resets the hand array to null and hand_size to 0
	public void resetHand()
	{
		hand = new Card[11];
		hand_size = 0;
	}
	
//	This is a special dev Test method I created, allowing 
//	me to force blackjacks and splits without playing the game for hours
	public void devDealPlayer()
	{
		addCard(new Card(2, 1));
		addCard(new Card(3, 1));
	}
	
//	This is a special dev Test method I created, allowing 
//	me to force blackjacks and splits without playing the game for hours
//	public void devDealDealer()
//	{
//		addCard(new Card(1, 9));
//		addCard(new Card(3, 2));
//	}
	
	//this method accepts a Card parameter and adds it to the Hand array
	//and then iterates the hand_size pointer up one
	public void addCard(Card card)
	{
		hand[hand_size++] = card;
	}
	
	//This prints out the whole hand and all its points
	public String toString()
	{
		String cards = ""; String ace = "";
		for (int i = 0; i < hand_size; i++)
		{
			if (hand[i].getFaceNumber() == 1)
				ace = " or 11";
			cards += "The " + hand[i] + " worth " + hand[i].getPoints() + 
			ace + " points" + " | ";
			ace = "";
		}
		return cards + "-- The total point score is: " + getPoints()
		+ " points" + "\n";
	}
	
	//this is similar to the toString method, however it just returns me the points
	//notice that ace adjusts based on point score up to 11 if the hand is less than 
	//or equal to 11 points
	public int getPoints()
	{
		int points = 0; boolean ace_present = false;
		for (int i = 0; i < hand_size; i++)
		{
			if (hand[i].getFaceNumber() == 1)
				ace_present = true;
			points += hand[i].getPoints();
		}
		if (ace_present == true && points <= 11)
			points = points + 10;
		return points;
	}
	
	//This checks for blackjack by looking at the first two cards
	public boolean blackJackCheck()
	{
		int points = 0; boolean ace_present = false;
		for (int i = 0; i <= 1; i++)
		{
			if (hand[i].getFaceNumber() == 1)
				ace_present = true;
			points += hand[i].getPoints();
		}
		if (ace_present == true && points <= 11)
			points = points + 10;
		if (points == 21)
		{
			return true;
		}
		else
			return false;
	}
	
	//this runs to determine if it is possible for a player to split their hand
	//by looking to see if the first and second card have the same number
	public boolean splitCheck()
	{
		if (hand[0].getFaceNumber() == hand[1].getFaceNumber())
			return true;
		else
			return false;
	}
	
	//This returns the 2ndCard in the hand
	//This was used for showing the Dealer's show card
	public String return2ndCard()
	{
		String ace = "";
		if (hand[1].getFaceNumber() == 1)
			ace = " or 11";
		String card = hand[1] + " worth " + hand[1].getPoints() + 
		ace + " points" + "\n";
		return card;
	}
	
	//This method accepts a card. Basically, during a split
	//I pass a new card from the deck to this method, and then
	//add the card to replace the card being sent to the 2nd hand.
	//This method returns the exit_card which is then used to add to 
	//the 2nd hand
	public Card split(Card replacement_card)
	{
		Card exit_card = hand[1];
		hand[1] = replacement_card;
		hand_size = 1;
		return exit_card;
	}
	
	//A quick method to tell me the size of the hand
	public int handSize()
	{
		return hand_size;
	}
}
