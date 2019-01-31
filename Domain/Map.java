import java.util.*;

public class Map {

	private ArrayList<Continent> continents;


	//costruttore da modificare
	public void setContinents(ArrayList<Continent> continents){
		this.continents = continents;
	}
	/**
	 * DA RIFARE QUANDO È INTEGRATO IL DB
	 * @param playerID
	 */

	public ArrayList getPlayerTerritories(String playerID) {
		ArrayList<Territory> playerTerritories = new ArrayList<Territory>();
		for(int i = 0; i<this.continents.size(); i++){
			Continent currentContinent = this.continents.get(i);
			ArrayList<Territory> currentTerritories = currentContinent.getTerritories();
			for(int j = 0; j<currentTerritories.size(); j ++){
				Player currentPlayer = currentTerritories.get(j).getOwner();
				if(playerID == currentPlayer.getID()){
					playerTerritories.add(currentTerritories.get(j));
				}
			}
		}
		return playerTerritories;
	}

	/**
	 * DA RIFARE QUANDO È INTEGRATO IL DB
	 * @param attackingTerritoryName
	 */
	public Territory getTerritorybyName(String territoryName) {
		/** IMPLEMENTAZIONE DI PROVA**/

		for (Continent continent:
			 this.continents) {
			for (Territory territory:
				 continent.territories) {
				if (territory.getName() == territoryName)
					return territory;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param playerID
	 * @param atkRule
	 */
	public ArrayList<Territory> getAttackingTerritory(String playerID, AttackRule atkRule) {
		return atkRule.calculateAttackingTerritory(this, playerID);
	}

	/**
	 * 
	 * @param nameAttackingTerritory
	 * @param atkRule
	 */
	public ArrayList getAttackableTerritories(String nameAttackingTerritory, AttackRule atkRule) {
		return atkRule.calculateAttackableTerritory(this, nameAttackingTerritory);
	}


}