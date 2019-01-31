import java.util.*;

public class DiceShaker {
	static private DiceShaker Instance = null;
	private ArrayList<Die> dice;

	//singleton
	private DiceShaker() {
		this.dice = new ArrayList<Die>();
	}

	static public DiceShaker getInstance()
	{
		if (Instance == null)
		    Instance = new DiceShaker();
		return DiceShaker.Instance;
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
				this.dice.add(new Die());
			}
		}
		else if (sizeVariation < 0)
		{
			int absSizeVariation = java.lang.Math.abs(sizeVariation);
			for (int i = 0; i < absSizeVariation; i++) {
				this.dice.remove(i);
			}
		}
		else if (dice == null)
		{
			for (int i = 0; i < DiceNumber; i++) {
				this.dice.add(new Die());
			}
		}
	}

	/**
	 *
	 */
	public void rollDice()
	{
		for ( int i = 0; i<this.dice.size(); i++){
			this.dice.get(i).roll();
		}
	}

	public ArrayList<Integer> getDiceValue()
	{
		ArrayList<Integer> diceValue = new ArrayList<Integer>();
		for (int i = 0; i<this.dice.size(); i++){
			diceValue.add(this.dice.get(i).getFaceValue());
		}
		return diceValue;
	}

	// to keep until testing is needed
/*
	public static void main(String[] args) {
		DiceShaker shaker = DiceShaker.getInstance();
		shaker.setDiceNumber(3);
		System.out.print(shaker.dice.size());
		shaker.setDiceNumber(2);
		System.out.print(shaker.dice.size());
		shaker.setDiceNumber(5);
		System.out.print(shaker.dice.size());
		shaker.rollDice();
		System.out.println(shaker.getDiceValue());
	}
	*/
}