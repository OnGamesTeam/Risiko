import java.util.ArrayList;

public class ClassicAttackRules implements AttackRule {

	/**
	 *
	 * @param currentAttack
	 */
	public void calculateAttackResult(Attack currentAttack) {
		Player attacker = currentAttack.getAttackingTerritory().getOwner();
		Player defender = currentAttack.getDefendingTerritory().getOwner();
		DiceShaker diceShaker = DiceShaker.getInstance();
		diceShaker.setDiceNumber(currentAttack.getAttackingArmiesNumber());
		diceShaker.rollDice();
		ArrayList<Integer> attackerDice = diceShaker.getDiceValue();
		diceShaker.setDiceNumber(currentAttack.getDefendingArmiesNumber());
		diceShaker.rollDice();
		ArrayList<Integer> defenderDice = diceShaker.getDiceValue();
		attackerDice.sort(null);
		defenderDice.sort(null):
		
	}

	/**
	 * 
	 * @param map
	 * @param playerID
	 */
	@Override
	public ArrayList calculateAttackingTerritory(Map map, String playerID) {
		ArrayList<Territory> playerTerritory = map.getPlayerTerritories(playerID);
		ArrayList<Territory> attackingTerritory = new ArrayList<Territory>();
		for(int i = 0; i<playerTerritory.size(); i++){
			Territory currentTerritory = playerTerritory.get(i);
			if(currentTerritory.getArmies() >= 2){
				attackingTerritory.add(currentTerritory);
			}
		}
		return attackingTerritory;
	}

	/**
	 * 
	 * @param map
	 * @param attackingTerritoryName
	 */
	public ArrayList calculateAttackableTerritory(Map map, String attackingTerritoryName) {
		Territory attackingTerritory= map.getTerritorybyName(attackingTerritoryName);
		ArrayList<Territory> attackableTerritories = new ArrayList<Territory>();
		for(Territory territory : attackingTerritory.getNeighbors()){
         if(territory.getOwner() != attackingTerritory.getOwner()){

         	attackableTerritories.add(territory);
		 }

		}
       return attackableTerritories;
	}

}