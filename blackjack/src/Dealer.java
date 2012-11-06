
public class Dealer 
{
	Hand dh1;
	Deck deck;
	
	public Dealer(Deck deck)
	{
		dh1 = new Hand();
		this.deck = deck;
	}
	
	public void dealDealerHand()
	{
		for (int i = 0; i < 2; i++)
		{
			Card card = deck.deal();
			dh1.addCard(card);
		}	
	}
	
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
	
	public Card playerHit()
	{
			return deck.deal();
	}
	
	public void dealerHit()
	{
		Card card = deck.deal();
		dh1.addCard(card);
		System.out.println("Dealer hits and gets a " + 
				card + " worth " + card.getPoints() + " points");
	}
	
	public void printHiddenHand()
	{
		System.out.print(dh1.return2ndCard());
		System.out.println("***********************************************************");
	}
	
	public Hand returnDealerHand()
	{
		return dh1;
	}
	
	public Hand getHand()
	{
		return dh1;
	}
}