import java.util.*;

public class Map {

	private ArrayList<Continent> continents;


	//costruttore da modificare
	public void setContinents(ArrayList<Continent> continents){
		this.continents = continents;
	}
	/**
	 * 
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
	 * 
	 * @param attackingTerritoryName
	 */
	public Territory getTerritorybyName(String attackingTerritoryName) {
		// TODO - implement Map.getTerritorybyName
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param playerID
	 * @param atkRule
	 */
	public Territory getAttackingTerritory(String playerID, AttackRule atkRule) {
		// TODO - implement Map.getAttackingTerritory
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nameAttackingTerritory
	 * @param atkRule
	 */
	public ArrayList getAttackableTerritories(String nameAttackingTerritory, AttackRule atkRule) {
		// TODO - implement Map.getAttackableTerritories
		throw new UnsupportedOperationException();
	}

}