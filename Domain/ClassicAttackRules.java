import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ClassicAttackRules implements AttackRule {

	/**
	 *
	 * @param currentAttack
	 */
	@Override
	public void calculateAttackResult(Attack currentAttack) {
		// dichiarazione di variabili
		Player attacker = currentAttack.getAttackingTerritory().getOwner();
		Player defender = currentAttack.getDefendingTerritory().getOwner();
		int lostDefenderArmies = 0;
		int lostAttackerArmiers = 0;
		boolean conquered = false;
		int totArmiesDefendingTerritory = currentAttack.getDefendingTerritory().getArmies();
		// fine dichiarazione
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
		// costruzione del risultato
		Result currentResult = new Result();
		currentResult.setDefDiceValue(defenderDice);
		currentResult.setAtkDiceValue(attackerDice);
		currentResult.setLostAttackingArmy(lostAttackerArmiers);
		currentResult.setLostDefendingArmy(lostDefenderArmies);
		currentResult.setConqueredDefendingTerritory(conquered);
		// collego il risultato all'attacco corrente
		currentAttack.setAttackResult(currentResult);


		this.updateMap(currentAttack);
	}

	@Override
	public void updateMap(Attack currentAttack){
		Scanner keyboard = new Scanner(System.in);

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

			System.out.println("ora in " + attackingTerritory.getName() + " ci sono " + attackingTerritory.getArmies() + " armate");
			System.out.println("e in " + defendingTerritory.getName() + " ci sono " + defendingTerritory.getArmies() + " armate");
		}

		else {
			//aggiornamento delle armate senza la conquista
			attackingTerritory.setArmies(new_armies_in_attacking_territory);
			defendingTerritory.setArmies(new_armies_in_defending_territory);

			System.out.println("ora in " + attackingTerritory.getName() + " ci sono " + attackingTerritory.getArmies() + " armate");
			System.out.println("e in " + defendingTerritory.getName() + " ci sono " + defendingTerritory.getArmies() + " armate");
		}
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

	public boolean checkDefendingArmies(int armiesOnTerritory, int defendingArmies)
	{
		if (defendingArmies > 3)
			return false;

		if (armiesOnTerritory < defendingArmies)
			return false;

		return true;
	}

}