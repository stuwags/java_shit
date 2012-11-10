/******************************
*  Player.java
*  written by Stuart Wagner
*  
********************************/
public class Player 
{
	private float money;//this keeps track of money
	private Hand ph1;//playerhand1
	private Hand ph2;//in the event of split
	private int number_of_hands;//This tells me the number of active hands
	
	//I create player, pass in starting_money, and set money
	//equal to starting money, I instantiate player hand 1
	//and set number of hands equal to 1
	public Player(float starting_money)
	{	
		money = starting_money;//sets money value for player
		ph1 = new Hand();
		number_of_hands = 1;
	}
	
	//This brings the gambling returns, positive or negative, 
	//and adds the positive to negative number back into Money
	//It then tells you how much you won or lost based on if bet
	//is negative or positive
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
	
	//Quick method to tell me how much money is left
	public float returnMoney()
	{
		return money; 
	}
	
	//This returns either the first or second player hand
	//based on the parameter I get it
	public Hand getHand(int which_hand)
	{
		if (which_hand == 1)
			return ph1;
		else
			return ph2;
	}
	
	//This prints the hand for me
	public void printHand(int which_hand)
	{
		System.out.print(getHand(which_hand));
	}
	
	//Split method in the player class accepts a card parameter
	//it creates the new hand and passes the card to the new hand 
	public void split(Card card)
	{
		ph2 = new Hand();
		ph2.addCard(card);
		number_of_hands++;
	}
	
	//resets number of hands
	public void resetNumberOfHands()
	{
		number_of_hands = 1;
	}
	
	//returns number of hands
	public int numberOfHands()
	{
		return number_of_hands;
	}
}
