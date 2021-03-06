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
	void updateMapNotConquered(Attack currentAttack);

	void updateMapConquered(Attack currentAttack, int armiesToMove);


	/**
	 * 
	 * @param map
	 * @param playerID
	 */
	ArrayList calculateAttackingTerritory(Map map, String playerID);

	/**
	 *
	 * @param map
	 * @param attackingTerritoryName
	 */
	ArrayList calculateAttackableTerritory(Map map, String attackingTerritoryName);

	/**
	 *
	 * @param armiesOnTerritory
	 * @param defendingArmies
	 * @return
	 */
	boolean checkDefendingArmies(int armiesOnTerritory, int defendingArmies);

	boolean checkArmiesToMove(int armiesOnTerritory, int attackArmies, int armiesToMove);

	boolean checkTerritoriesValidity(Territory attackingTerritory, Territory defendingTerritory, String attacckingPlayerId);

	boolean checkAttackingArmiesValidity(Territory attackingTerritory, int attackingArmies);



}