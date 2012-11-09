
public class Hand 
{
	
	//11 is max hand size in blackjack, because 4 aces and 4 twos and 3 threes make up 21
	private Card[] hand; private int hand_size;
	
	public Hand()
	{	 
		hand = new Card[11];
		hand_size = 0;
	}
	
	public void resetHand()
	{
		hand = new Card[11];
		hand_size = 0;
	}
	
	public void devDealPlayer()
	{
		addCard(new Card(2, 1));
		addCard(new Card(3, 1));
	}
	
	public void devDealDealer()
	{
		addCard(new Card(1, 2));
		addCard(new Card(3, 1));
	}
	
	public void addCard(Card card)
	{
		hand[hand_size++] = card;
	}
	
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
	
	public boolean splitCheck()
	{
		if (hand[0].getFaceNumber() == hand[1].getFaceNumber())
			return true;
		else
			return false;
	}
	
	public String return2ndCard()
	{
		String ace = "";
		if (hand[1].getFaceNumber() == 1)
			ace = " or 11";
		String card = hand[1] + " worth " + hand[1].getPoints() + 
		ace + " points" + "\n";
		return card;
	}
	
	public Card split(Card replacement_card)
	{
		Card exit_card = hand[1];
		hand[1] = replacement_card;
		hand_size = 1;
		return exit_card;
	}
	
	public int handSize()
	{
		return hand_size;
	}
}
