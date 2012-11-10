/******************************
*  Card.java
*  written by Stuart Wagner
*  
********************************/
public class Card 
{
	//Cards have suits, face_nubmers, and points
	private int suit; private int face_number; private int points;
	
	//They have an array of Strings that translate to face numbers
	private final String[] card_label = { "Ace", "Two", "Three", "Four", "Five",
			"Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
	//and an array of suits translated for their suit number
	private final String[] card_suit = { "Diamonds", "Hearts", "Clubs", "Spades" };
	
	//they take suit and face_number constructors to
	//set them to the instance variable of the instantiated object
	public Card(int suit, int face_number)
	{
		this.suit = suit;
		this.face_number = face_number;
		if (face_number >= 10)
			points = 10;
		else
			points = face_number;
	}
	
	//returns raw points
	public int getPoints()
	{
		return points;
	}
	
	//returns facenumber
	public int getFaceNumber()
	{
		return face_number;
	}
	
	//returns card string
	public String toString()
	{
		return card_label[face_number-1] + " of " + card_suit[suit];
	}
}