import java.util.ArrayList;

public class CombatPhaseHandler {

	Turn currentTurn;
	AttackRule atkRule;
	Map map;

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
	public ArrayList showAttackingTerritories(String playerID) {
		// TODO - implement CombatPhaseHandler.showAttackingTerritories
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param attackingTerritoryName
	 */
	public ArrayList showAttackableTerritories(String attackingTerritoryName) {
		// TODO - implement CombatPhaseHandler.showAttackableTerritories
		throw new UnsupportedOperationException();
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