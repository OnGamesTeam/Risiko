import java.util.*;

public class DiceShaker {
	static private DiceShaker Instance = null;
	private Deque<Die> dice;

	//singleton
	private DiceShaker() {
		this.dice = new LinkedList<Die>();
	}

	static public DiceShaker getInstance()
	{
		if (Instance != null)
			return Instance;
		else
			{
				Instance = new DiceShaker();
				return Instance;
			}
	}

	/**
	 *
	 * @param DiceNumber
	 */
	public void setDiceNumber(int DiceNumber)
	{
		int sizeVariation = DiceNumber - this.dice.size();
		if (sizeVariation > 0)
		{
			for (int i = 0; i < sizeVariation; i++) {
				this.dice.push(new Die());
			}
		}
		else if (sizeVariation < 0)
		{
			int absSizeVariation = java.lang.Math.abs(sizeVariation);
			for (int i = 0; i < absSizeVariation; i++) {
				this.dice.pop();
			}
		}
		else if (dice == null)
		{
			for (int i = 0; i < DiceNumber; i++) {
				this.dice.push(new Die());
			}
		}
	}

	/**
	 *
	 */
	public void rollDice()
	{
		for (Die die:
			 this.dice) {
			die.roll();
		}
	}

	public void getDiceValue(int dieNumber)
	{
		//TODO
	}

	// to keep until testing is needed
	public static void main(String[] args) {
		DiceShaker shaker = DiceShaker.getInstance();
		shaker.setName("soreta");
		shaker.hi();
		shaker.setDiceNumber(3);
		System.out.print(shaker.dice.size());
		shaker.setDiceNumber(2);
		System.out.print(shaker.dice.size());
		shaker.setDiceNumber(5);
		System.out.print(shaker.dice.size());
		shaker.setDiceNumber(1);
		System.out.print(shaker.dice.size());
	}
}