
public class Player 
{
	private float money;
	Hand ph1;//playerhand1
	Hand ph2;//in the event of split
	
	public Player(float starting_money)
	{	
		money = starting_money;//sets money value for player
		ph1 = new Hand(); ph2 = new Hand();
	}
	
	public void gambleReturns(float bet)
	{
		money = money + bet;
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
}
