public interface AttackRule {

	/**
	 * 
	 * @param currentAttack
	 */
	void calculateAttackResult(Attack currentAttack);

	/**
	 * 
	 * @param map
	 * @param playerID
	 */
	ArrayList calculateAttackingTerritory(Map map, string playerID);

	/**
	 * 
	 * @param parameter
	 * @param map
	 * @param attackingTerritoryName
	 */
	ArrayList calculateAttackableTerritory(Map map, string attackingTerritoryName);

}