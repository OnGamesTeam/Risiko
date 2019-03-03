public class Attack {

	private int attackingArmiesNumber;
	private int defendingArmiesNumber;
	private Result attackResult;
	private Territory attackingTerritory;
	private Territory defendingTerritory;


	public Result getResult() {
		return this.attackResult;
	}

	public Territory getAttackingTerritory() {
		return this.attackingTerritory;
	}

	/**
	 * 
	 * @param attackingTerritory
	 */
	public void setAttackingTerritory(Territory attackingTerritory) {
		this.attackingTerritory = attackingTerritory;
	}

	public Territory getDefendingTerritory() {
		return this.defendingTerritory;
	}

	/**
	 * 
	 * @param defendingTerritory
	 */
	public void setDefendingTerritory(Territory defendingTerritory) {
		this.defendingTerritory = defendingTerritory;
	}

	public Result getAttackResult(AttackRule atkRules){
		atkRules.calculateAttackResult(this);
		return this.getResult();
	}

	/**
	 * 
	 * @param attackResult
	 */
	public void setAttackResult(Result attackResult) {
		this.attackResult = attackResult;
	}

	public int getAttackingArmiesNumber() {
		return attackingArmiesNumber;
	}

	public void setAttackingArmiesNumber(int attackingArmiesNumber) {
		this.attackingArmiesNumber = attackingArmiesNumber;
	}

	public int getDefendingArmiesNumber() {
		return defendingArmiesNumber;
	}

	public void setDefendingArmiesNumber(int defendingArmiesNumber) {
		this.defendingArmiesNumber = defendingArmiesNumber;
	}

	@Override
	public String toString() {
		return "Atk: " + this.getAttackingTerritory() + " AtkArmies: " + this.getAttackingArmiesNumber() + " Def: " + this.getDefendingTerritory() + " DefArmies: " + this.getDefendingArmiesNumber() + " Result: " + this.getResult();
	}

	public Result getAttackResult() {
		return this.attackResult;
	}
}