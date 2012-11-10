/******************************
*  Dealer.java
*  written by Stuart Wagner
*  
********************************/
public class Dealer 
{
	private Hand dh1;
	private Deck deck;

	
	//instantiates new dealer hand and 
	//gets deck accessible
	public Dealer(Deck deck)
	{
		dh1 = new Hand();
		this.deck = deck;
	}
	
	//this deals two cards to the
	//dealer hand
	public void dealDealerHand()
	{
		for (int i = 0; i < 2; i++)
		{
			Card card = deck.deal();
			dh1.addCard(card);
		}	
	}
	
	//returns two cards to be added
	//to the player hand
	public Card[] dealPlayerHand()
	{
		Card[] two_cards = new Card[2];
		for (int i = 0; i < 2; i++)
		{
			Card card = deck.deal();
			two_cards[i] = card;
		}
		return two_cards;
	}
	
	//returns a single card form the deck
	public Card playerHit()
	{
		return deck.deal();
	}
	
	//This deals a card to dealer
	//incorparating ace values
	public void dealerHit()
	{
		Card card = deck.deal();
		dh1.addCard(card);
		if (card.getFaceNumber() == 1)
		{
			System.out.println("Dealer hits and gets a " + card + 
					" worth " + card.getPoints() + " of 11 points");
		}
		else
		{
		System.out.println("Dealer hits and gets a " + 
				card + " worth " + card.getPoints() + " points");
		}
	}
	
	//this prints the single show card for dealer
	public void printHiddenHand()
	{
		System.out.print(dh1.return2ndCard());
	}
	
	//returns dealer hand
	public Hand returnDealerHand()
	{
		return dh1;
	}
}