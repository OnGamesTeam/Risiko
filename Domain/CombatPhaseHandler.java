import java.util.ArrayList;

public class CombatPhaseHandler {

	Turn currentTurn;
	AttackRule atkRule;
	Map map;

    public CombatPhaseHandler(Turn currentTurn, AttackRule atkRule, Map map) {
        this.currentTurn = currentTurn;
        this.atkRule = atkRule;
        this.map = map;
    }

    public boolean startCombatPhase() {

        Boolean noError;
        try {
			this.currentTurn.newCombatPhase();
			noError = true;
		}
		catch(Exception Error){

        	noError =false;
		}
        return noError;
	}

	/**
	 * 
	 * @param playerID
	 */
	public ArrayList<Territory> showAttackingTerritories(String playerID) {
		return this.map.getAttackingTerritory(playerID, this.atkRule);
	}

	/**
	 * 
	 * @param attackingTerritoryName
	 */
	public ArrayList showAttackableTerritories(String attackingTerritoryName) {
		return this.map.getAttackableTerritories(attackingTerritoryName, this.atkRule);
	}

	public boolean makeAttack(String attackingTerritoryName, String defendingTerritoryName, int attackingArmyNumber)
	{
		//TODO
        Territory atkTerritory = this.map.getTerritorybyName(attackingTerritoryName);
        Territory defTerritory = this.map.getTerritorybyName(defendingTerritoryName);
        CombatPhase currentCPhase = this.currentTurn.getCombatPhase();
        return true;
	}

	public Result calculateAttackResult() {
		// TODO - implement CombatPhaseHandler.calculateAttackResult
		throw new UnsupportedOperationException();
	}

	public boolean endCombatPhase() {
		// TODO - implement CombatPhaseHandler.endCombatPhase
		throw new UnsupportedOperationException();
	}

}