import java.util.ArrayList;

public class Result {

	private ArrayList<Integer> atkDiceValue;
	private ArrayList<Integer> defDiceValue;
	private int lostAttackingArmy;
	private int lostDefendingArmy;
	private boolean conqueredDefendingTerritory;

	public ArrayList getAtkDiceValue() {
		return this.atkDiceValue;
	}

	/**
	 * 
	 * @param atkDiceValue
	 */
	public void setAtkDiceValue(ArrayList atkDiceValue) {
		this.atkDiceValue = atkDiceValue;
	}

	public ArrayList getDefDiceValue() {
		return this.defDiceValue;
	}

	/**
	 * 
	 * @param defDiceValue
	 */
	public void setDefDiceValue(ArrayList defDiceValue) {
		this.defDiceValue = defDiceValue;
	}

	public int getLostAttackingArmy() {
		return this.lostAttackingArmy;
	}

	/**
	 * 
	 * @param lostAttackingArmy
	 */
	public void setLostAttackingArmy(int lostAttackingArmy) {
		this.lostAttackingArmy = lostAttackingArmy;
	}

	public int getLostDefendingArmy() {
		return this.lostDefendingArmy;
	}

	/**
	 * 
	 * @param lostDefendingArmy
	 */
	public void setLostDefendingArmy(int lostDefendingArmy) {
		this.lostDefendingArmy = lostDefendingArmy;
	}

	public boolean getConqueredDefendingTerritory() {
		return this.conqueredDefendingTerritory;
	}

	/**
	 * 
	 * @param conqueredDefendingTerritory
	 */
	public void setConqueredDefendingTerritory(boolean conqueredDefendingTerritory) {
		this.conqueredDefendingTerritory = conqueredDefendingTerritory;
	}

}