import java.util.ArrayList;
import java.util.Scanner;

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
	    return this.map.getAttackingTerritory(playerID,this.atkRule);
    }

	/**
	 * 
	 * @param attackingTerritoryName
	 */
	public ArrayList<Territory> showAttackableTerritories(String attackingTerritoryName) {
	    return this.map.getAttackableTerritories(attackingTerritoryName, this.atkRule);
    }

	public boolean makeAttack(String attackingTerritoryName, String defendingTerritoryName, int attackingArmyNumber)
	{
		//TODO

        Territory atkTerritory = this.map.getTerritorybyName(attackingTerritoryName);
        Territory defTerritory = this.map.getTerritorybyName(defendingTerritoryName);
        CombatPhase currentCPhase = this.currentTurn.getCombatPhase();
        currentCPhase.makeNewAttack(atkTerritory,defTerritory,attackingArmyNumber);

        //fase di test, questo controllo non è sufficiente
        return true;
	}

	public boolean setDefendingArmiesNumber(int DefendingArmiesNumber){
	    CombatPhase currentCPhase = this.currentTurn.getCombatPhase();
	    Attack attack = currentCPhase.getCurrentAttack();
	    //
	    if (!(this.atkRule.checkDefendingArmies(attack.getDefendingTerritory().getArmies(),
				DefendingArmiesNumber)))
	    	return false;

	    attack.setDefendingArmiesNumber(DefendingArmiesNumber);
	    return true;
    }


	public void calculateAttackResult() {
		int armiesToMove = 0;
        CombatPhase currentCPhase = this.currentTurn.getCombatPhase();
        Attack attack = currentCPhase.getCurrentAttack();
        Result result = attack.getAttackResult(this.atkRule);
        this.showResult(result);
        if(result.getConqueredDefendingTerritory()){
        	do {
				armiesToMove = this.askArmiesNumberToMove();
			}
        	while (this.atkRule.chekArmiesToMove(attack.getAttackingTerritory().getArmies(), attack.getAttackingArmiesNumber(),armiesToMove));
        	this.atkRule.updateMapConquered(attack, armiesToMove);
		}
        else this.atkRule.updateMapNotConquered(attack);
    }

	public boolean endCombatPhase() {
		// TODO - implement CombatPhaseHandler.endCombatPhase
		throw new UnsupportedOperationException();
	}

	public void showResult(Result result){
		System.out.println(result);
	}

	public int askArmiesNumberToMove(){
		System.out.println("Territorio conquistato! Quante armate vuoi spostare?");
		Scanner keyboard = new Scanner(System.in);
		return keyboard.nextInt();
	}


}