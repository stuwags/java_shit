//mathematics 203

public class Deck 
{
	final private int deck_size = 52;
	final private Card[] deck = new Card[deck_size];
	private int deck_loc;
	
	public Deck()
	{
		for (int suit = 0; suit < 4; suit++)
		{
			for (int face_number = 1; face_number < 14; face_number++)
			{
				deck[13*suit+(face_number - 1)] = new Card(suit, face_number);
			}
		}
		shuffle();
	}
	
	public void shuffle()
	{
		for (int i = 0; i < 1000000; i++)
		{
			int place1 = (int)(Math.random()*52); int place2 = (int)(Math.random()*52);
			Card temp1 = deck[place1]; Card temp2 = deck[place2];
			deck[place2] = temp1; deck[place1] = temp2;
		}
		deck_loc = 0;
	}
	
	public Card deal()
	{
		return deck[deck_loc++];
		//returns deck_loc and then adds 1
	}
	
	public int getDeckLoc()
	{
		return deck_loc;
	}
}