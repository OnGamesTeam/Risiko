import java.util.ArrayList;

public interface AttackRule {

	/**
	 * 
	 * @param currentAttack
	 */
	void calculateAttackResult(Attack currentAttack);

	/**
	 *
	 * @param currentAttack
	 */
	void updateMap(Attack currentAttack);


	/**
	 * 
	 * @param map
	 * @param playerID
	 */
	ArrayList calculateAttackingTerritory(Map map, String playerID);

	/**
	 * 
	 * @param parameter
	 * @param map
	 * @param attackingTerritoryName
	 */
	ArrayList calculateAttackableTerritory(Map map, String attackingTerritoryName);



}