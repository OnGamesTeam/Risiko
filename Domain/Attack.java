public class Attack {

	private Territory attackingTerritory;
	private Territory defendingTerritory;
	private int attackingArmiesNumber;
	private int defendingArmiesNumber;
	private Result attackResult;

	/**
	 * 
	 * @param atkRules
	 */
	public Result getAttackResult(AttackRule atkRules) {
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

	public Result getAttackResult() {
		return this.attackResult;
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

}