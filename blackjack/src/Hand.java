
public class Hand 
{
	
	//11 is max hand size in blackjack, because 4 aces and 4 twos and 3 threes make up 21
	private Card[] hand; public int hand_size;
	
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
	
	public void addCard(Card card)
	{
		hand[hand_size++] = card;
	}
	
	public String toString()
	{
		String cards = "";
		int points = 0;
		for (int i = 0; i < hand_size; i++)
		{
			points += hand[i].getPoints();
			cards += "The " + hand[i] + " worth " + hand[i].getPoints()
			+ " points" + " | ";
		}
		return cards + "\n" + "The total point score is: " + points
		+ " points" + "\n";
	}
	
	public int getPoints()
	{
		int points = 0;
		for (int i = 0; i < hand_size; i++)
		{
			points += hand[i].getPoints();
		}
		return points;
	}
	
	public String return2ndCard()
	{
		String card = hand[1] + " worth " + hand[1].getPoints() +
				" points" + "\n";
		return card;
	}
	
	public int handSize()
	{
		return hand_size;
	}
}
