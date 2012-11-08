
public class Card 
{
	
	private int suit; private int face_number; private int points;
	
	final String[] card_label = { "Ace", "Two", "Three", "Four", "Five",
			"Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
	
	final String[] card_suit = { "Diamonds", "Hearts", "Clubs", "Spades" };
	
	public Card(int suit, int face_number)
	{
		this.suit = suit;
		this.face_number = face_number;
		if (face_number >= 10)
			points = 10;
		else
			points = face_number;
	}
	
	public int getPoints()
	{
		return points;
	}
	
	public int getFaceNumber()
	{
		return face_number;
	}
	
	public String toString()
	{
		return card_label[face_number-1] + " of " + card_suit[suit];
	}
}