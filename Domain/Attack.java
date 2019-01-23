public class Attack {

	private Territory attackingTerritory;
	private Territory defendingTerritory;
	private int attackingArmiesNumber;
	private int defendingArmiesNumber;
	Result attackResult;

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
		// TODO - implement Attack.getAttackingArmiesNumber
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param attackingArmiesNumber
	 */
	public void setAttackingArmiesNumber(int attackingArmiesNumber) {
		// TODO - implement Attack.setAttackingArmiesNumber
		throw new UnsupportedOperationException();
	}

	public int getDefendingArmiesNumber() {
		// TODO - implement Attack.getDefendingArmiesNumber
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param defendingArmiesNumber
	 */
	public void setDefendingArmiesNumber(int defendingArmiesNumber) {
		// TODO - implement Attack.setDefendingArmiesNumber
		throw new UnsupportedOperationException();
	}

}