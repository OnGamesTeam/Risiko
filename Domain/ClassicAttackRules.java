import java.util.ArrayList;
import java.util.Collections;

public class ClassicAttackRules implements AttackRule {

	/**
	 *
	 * @param currentAttack
	 */
	@Override
	public void calculateAttackResult(Attack currentAttack) {

		// dichiarazione di variabili
		Player attacker = currentAttack.getAttackingTerritory().getTerritoryStatus().getOwner();
		Player defender = currentAttack.getDefendingTerritory().getTerritoryStatus().getOwner();
		int lostDefenderArmies = 0;
		int lostAttackerArmiers = 0;
		boolean conquered = false;
		int totArmiesDefendingTerritory = currentAttack.getDefendingTerritory().getTerritoryStatus().getArmies();
		// fine dichiarazione

		//calcolo del risultato
		DiceShaker diceShaker = DiceShaker.getInstance(); //ottengo l'istanza del diceshaker
		diceShaker.setDiceNumber(currentAttack.getAttackingArmiesNumber()); // setto il numero di dadi che l'attaccante deve lanciare
		diceShaker.rollDice(); // lancio i dadi di attacco
		ArrayList<Integer> attackerDice = diceShaker.getDiceValue(); // ottengo i valori dei dadi dell'attaccante
		diceShaker.setDiceNumber(currentAttack.getDefendingArmiesNumber()); // setto il numero di dadi che il difensore deve lanciare
		diceShaker.rollDice(); // lancio i dadi di difesa
		ArrayList<Integer> defenderDice = diceShaker.getDiceValue(); // ottengo i valori dei dadi del difensore
		Collections.sort(attackerDice, Collections.reverseOrder()); // ordino i dadi di attacco dal più grande al più piccolo
		Collections.sort(defenderDice,Collections.reverseOrder()); // ordino i dadi di difesa dal più grande al più piccolo
		for(int i = 0; (i<attackerDice.size() && i<defenderDice.size()); i++){ // confronto i due insiemi di dadi
			if(attackerDice.get(i)>defenderDice.get(i)){ // se l'i-esimo dado di attacco e maggiore dell'i-esimo dado di difesa...
				lostDefenderArmies++; // ... incremento il numero di armate perse dal difensore
			}
			else lostAttackerArmiers++; // ... altrimenti incremento il numero di armate perse dall'attaccante
		}
		if(totArmiesDefendingTerritory - lostDefenderArmies == 0){ // se il numero totale di armate sul terriorio difensore - quelle perse è uguale a 0...
			conquered = true; // ... c'è stata la conquista
		}
		//fine calcolo del risultato

		// costruzione del risultato
		Result currentResult = new Result();
		currentResult.setDefDiceValue(defenderDice);
		currentResult.setAtkDiceValue(attackerDice);
		currentResult.setLostAttackingArmy(lostAttackerArmiers);
		currentResult.setLostDefendingArmy(lostDefenderArmies);
		currentResult.setConqueredDefendingTerritory(conquered);
		// collego il risultato all'attacco corrente
		currentAttack.setAttackResult(currentResult);
	}


	public void updateMapNotConquered(Attack currentAttack){
		Territory attackingTerritory = currentAttack.getAttackingTerritory();
		Territory defendingTerritory = currentAttack.getDefendingTerritory();

		//CALCOLO DELLE NUOVE ARMATE NEL TERRITORIO DI ATTACCO
		int old_armies_in_attacking_territory = attackingTerritory.getTerritoryStatus().getArmies();
		int new_armies_in_attacking_territory = old_armies_in_attacking_territory - currentAttack.getResult().getLostAttackingArmy();

		//CALCOLO DELLE NUOVE ARMATE NEL TERRITORIO DI DIFESA
		int old_armies_in_defending_territory = defendingTerritory.getTerritoryStatus().getArmies();
		int new_armies_in_defending_territory = old_armies_in_defending_territory - currentAttack.getResult().getLostDefendingArmy();

		attackingTerritory.getTerritoryStatus().setArmies(new_armies_in_attacking_territory);
		defendingTerritory.getTerritoryStatus().setArmies(new_armies_in_defending_territory);
	}


	public void updateMapConquered(Attack currentAttack, int armiesToMove){
		Territory attackingTerritory = currentAttack.getAttackingTerritory();
		Territory defendingTerritory = currentAttack.getDefendingTerritory();

		//CALCOLO DELLE NUOVE ARMATE NEL TERRITORIO DI ATTACCO
		int old_armies_in_attacking_territory = attackingTerritory.getTerritoryStatus().getArmies();
		int new_armies_in_attacking_territory = old_armies_in_attacking_territory - currentAttack.getResult().getLostAttackingArmy();

		//CALCOLO DELLE NUOVE ARMATE NEL TERRITORIO DI DIFESA
		int old_armies_in_defending_territory = defendingTerritory.getTerritoryStatus().getArmies();
		int new_armies_in_defending_territory = old_armies_in_defending_territory - currentAttack.getResult().getLostDefendingArmy();

		//VIENE CAMBIATO L'OWNER DEL TERRITORIO CONQUISTATO
		defendingTerritory.getTerritoryStatus().setOwner(attackingTerritory.getTerritoryStatus().getOwner());

		//VENGONO SPOSTATE LE ARMATE DAL TERRITORIO DI ATTACCO A QUELLO DI DIFESA
		defendingTerritory.getTerritoryStatus().setArmies(armiesToMove);
		attackingTerritory.getTerritoryStatus().setArmies(new_armies_in_attacking_territory-armiesToMove);
	}


	/**
	 * 
	 * @param map
	 * @param playerID
	 */

	public ArrayList calculateAttackingTerritory(Map map, String playerID) {
		ArrayList<Territory> playerTerritory = map.getPlayerTerritories(playerID);
		ArrayList<Territory> attackingTerritory = new ArrayList<Territory>();
		for(int i = 0; i<playerTerritory.size(); i++){
			Territory currentTerritory = playerTerritory.get(i);
			if(currentTerritory.getTerritoryStatus().getArmies() >= 2){
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
         if(territory.getTerritoryStatus().getOwner() != attackingTerritory.getTerritoryStatus().getOwner()){

         	attackableTerritories.add(territory);
		 }

		}
       return attackableTerritories;
	}

	public boolean checkDefendingArmies(int armiesOnTerritory, int defendingArmies)
	{
		if (defendingArmies > 3)
			return false;

		if (armiesOnTerritory < defendingArmies)
			return false;

		return true;
	}

	public boolean checkArmiesToMove(int armiesOnTerritory, int attackArmies, int armiesToMove){
		if(armiesToMove >= attackArmies && armiesToMove < armiesOnTerritory) return true;
		else return false;
	}


	public boolean checkTerritoriesValidity(Territory attackingTerritory, Territory defendingTerritory, String attacckingPlayerId){
		boolean validity = false;
		if (attackingTerritory.getTerritoryStatus().getOwner().getID().equals(attacckingPlayerId) && attackingTerritory.getNeighbors().contains(defendingTerritory) && !(defendingTerritory.getTerritoryStatus().getOwner().getID().equals(attacckingPlayerId))){
			validity = true;
		}
		return validity;
	}

	public boolean checkAttackingArmiesValidity(Territory attackingTerritory, int attackingArmies){
		boolean validity = false;
		if (attackingArmies <= 3 && attackingTerritory.getTerritoryStatus().getArmies()-attackingArmies >=1){
			validity = true;
		}
		return validity;
	}
	
}