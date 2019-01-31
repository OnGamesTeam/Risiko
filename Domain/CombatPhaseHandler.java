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

	public void updateMap(Attack currentAttack){
		Scanner keyboard = new Scanner(System.in);


		// Attack currentAttack = currentTurn.getCombatPhase().getCurrentAttack();

		Territory attackingTerritory = currentAttack.getAttackingTerritory();
		Territory defendingTerritory = currentAttack.getDefendingTerritory();

		//CALCOLO DELLE NUOVE ARMATE NEL TERRITORIO DI ATTACCO
		int old_armies_in_attacking_territory = attackingTerritory.getArmies();
		int new_armies_in_attacking_territory = old_armies_in_attacking_territory - currentAttack.getResult().getLostAttackingArmy();

		//CALCOLO DELLE NUOVE ARMATE NEL TERRITORIO DI DIFESA
		int old_armies_in_defending_territory = defendingTerritory.getArmies();
		int new_armies_in_defending_territory = old_armies_in_defending_territory - currentAttack.getResult().getLostDefendingArmy();

		// if che controlla la conquista di un territorio
		if (currentAttack.getResult().getConqueredDefendingTerritory()){

			int moved_armies = 0;
			//setta il territorio in difesa come posseduto dal giocatore attaccante
			defendingTerritory.setOwner(attackingTerritory.getOwner());

			//si aspetta che l'attaccante dichiari quante armate vuole spostare
			while ( !(moved_armies >= currentAttack.getAttackingArmiesNumber() && moved_armies < new_armies_in_attacking_territory)) {
				System.out.print("Hai conquistato" + currentAttack.getDefendingTerritory().getName() + ", quante armate vuoi spostare?");
				moved_armies = keyboard.nextInt();
			}

			//spostamento delle armate dal territorio attaccante a quello conquistato
			defendingTerritory.setArmies(moved_armies);
			attackingTerritory.setArmies(new_armies_in_attacking_territory-moved_armies);

			System.out.println("ora in" + attackingTerritory.getName() + " ci sono" + attackingTerritory.getArmies() + " armate");
			System.out.println(" e in" + defendingTerritory.getName() + " ci sono" + defendingTerritory.getArmies() + "armate");
		}

		else {
			//aggiornamento delle armate senza la conquista
			attackingTerritory.setArmies(new_armies_in_attacking_territory);
			defendingTerritory.setArmies(new_armies_in_defending_territory);

			System.out.println("ora in" + attackingTerritory.getName() + " ci sono" + attackingTerritory.getArmies() + " armate");
			System.out.println(" e in" + defendingTerritory.getName() + " ci sono" + defendingTerritory.getArmies() + "armate");
		}
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
	public ArrayList showAttackingTerritories(String playerID) {
	    return this.map.getAttackingTerritory(playerID,this.atkRule);
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
        currentCPhase.makeNewAttack(atkTerritory,defTerritory,attackingArmyNumber);

        //fase di test, questo controllo non è sufficiente
        return true;
	}

	public boolean setDefendingArmiesNumber(int DefendingArmiesNumber){
	    CombatPhase currentCPhase = this.currentTurn.getCombatPhase();
	    Attack attack = currentCPhase.getCurrentAttack();
	    attack.setDefendingArmiesNumber(DefendingArmiesNumber);
	    return true;
    }
	public Result calculateAttackResult() {
        CombatPhase currentCPhase = this.currentTurn.getCombatPhase();
        Attack attack = currentCPhase.getCurrentAttack();
        return attack.getAttackResult(this.atkRule);
    }

	public boolean endCombatPhase() {
		// TODO - implement CombatPhaseHandler.endCombatPhase
		throw new UnsupportedOperationException();
	}


}