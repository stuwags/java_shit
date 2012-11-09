
public class Player 
{
	private float money;
	private Hand ph1;//playerhand1
	private Hand ph2;//in the event of split
	private int number_of_hands;
	
	public Player(float starting_money)
	{	
		money = starting_money;//sets money value for player
		ph1 = new Hand();
		number_of_hands = 1;
	}
	
	public void gambleReturns(float bet)
	{
		money = money + bet;
		if (bet < 0)
			System.out.println("You lost $" + (bet * -1) + " and now have $" + returnMoney() + 
		" after incorporating your bet");
		else if (bet >= 0)
			System.out.println("You gained $" + bet + " and now have $" + returnMoney() + 
		" after incorporating your bet");
	}
	
	public float returnMoney()
	{
		return money; 
	}
	
	public Hand getHand(int which_hand)
	{
		if (which_hand == 1)
			return ph1;
		else
			return ph2;
	}
	
	public void printHand(int which_hand)
	{
		System.out.print(getHand(which_hand));
	}
	
	public void split(Card card)
	{
		ph2 = new Hand();
		ph2.addCard(card);
		number_of_hands++;
	}
	
	public void resetNumberOfHands()
	{
		number_of_hands = 1;
	}
	
	public int numberOfHands()
	{
		return number_of_hands;
	}
}
