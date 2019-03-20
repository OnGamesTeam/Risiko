package Domain;

import java.util.ArrayList;
import java.util.List;
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
	public List<Territory> showAttackingTerritories(String playerID) {
	    return this.map.getAttackingTerritory(playerID,this.atkRule);
    }

	/**
	 * 
	 * @param attackingTerritoryName
	 */
	public List<Territory> showAttackableTerritories(String attackingTerritoryName, String playerID) {
		//nel caso potrebbe essere utile indicare il motivo per cui un territorio non ha territori attaccabili vicini
		if (playerID.equals(this.map.getTerritorybyName(attackingTerritoryName).getTerritoryStatus().getOwner().getID()))
	    	return this.map.getAttackableTerritories(attackingTerritoryName, this.atkRule);
		return new ArrayList<>();
    }

	public boolean makeAttack(String attackingTerritoryName, String defendingTerritoryName, int attackingArmyNumber, String currentPlayer)
	{
		//TODO

        Territory atkTerritory = this.map.getTerritorybyName(attackingTerritoryName);
        Territory defTerritory = this.map.getTerritorybyName(defendingTerritoryName);

        boolean territoriesValidity = atkRule.checkTerritoriesValidity(atkTerritory, defTerritory, currentPlayer);

        if (territoriesValidity == false){

			System.out.println("I territori d'attacco non sono corretti. ");
			return false;
		}

		boolean armiesValidity = atkRule.checkAttackingArmiesValidity(atkTerritory, attackingArmyNumber);

		if (armiesValidity == false){
			System.out.println("Non puoi attaccare con questo numero di armate! ");
			return false;
		}

        CombatPhase currentCPhase = this.currentTurn.getCombatPhase();
        currentCPhase.makeNewAttack(atkTerritory,defTerritory,attackingArmyNumber);

        //fase di test, questo controllo non è sufficiente
        return true;
	}

	public boolean setDefendingArmiesNumber(int DefendingArmiesNumber){
	    CombatPhase currentCPhase = this.currentTurn.getCombatPhase();
	    Attack attack = currentCPhase.getCurrentAttack();
	    //
	    if (!(this.atkRule.checkDefendingArmies(attack.getDefendingTerritory().getTerritoryStatus().getArmies(),
				DefendingArmiesNumber)))
	    	return false;

	    attack.setDefendingArmiesNumber(DefendingArmiesNumber);
	    return true;
    }


	public Result calculateAttackResult() {
		int armiesToMove = 0;
		//prendo la fase corrente
        CombatPhase currentCPhase = this.currentTurn.getCombatPhase();
        //prendo l'attacco corrente
        Attack attack = currentCPhase.getCurrentAttack();
        //calcolo il risultato
        Result result = attack.getAttackResult(this.atkRule);
        //mostro il risultato
        this.showResult(result);
        // il territorio è stato conquistato...
        if(result.getConqueredDefendingTerritory()){ //
        	do {
				armiesToMove = this.askArmiesNumberToMove(); //SI: chiedo all'attaccante quante armate vuole spostare dal territorio attaccante
			}
        	while (!this.atkRule.checkArmiesToMove(attack.getAttackingTerritory().getTerritoryStatus().getArmies(), attack.getAttackingArmiesNumber(),armiesToMove)); //controllo che possa spostare  tot armate
        	this.atkRule.updateMapConquered(attack, armiesToMove); //aggiorno la mappa in seguito alla conquista
		}
        else this.atkRule.updateMapNotConquered(attack); //NO: aggiorno direttamente la mappa
		return result;
    }

	public boolean endCombatPhase() {
		// TODO - implement Domain.CombatPhaseHandler.endCombatPhase
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