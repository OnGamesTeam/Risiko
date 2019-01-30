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
		// TODO - implement Map.getPlayerTerritories
		throw new UnsupportedOperationException();
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

	public static void main(String[] args) {
		Territory territorioprova = new Territory("Italia");
		Territory territorioprova2 = new Territory("Francia");
		Territory territorioprova3 = new Territory("Svizzera");
		territorioprova.addNeighbor(territorioprova2);
		territorioprova.addNeighbor(territorioprova3);
		territorioprova2.addNeighbor(territorioprova);
		territorioprova2.addNeighbor(territorioprova3);
		ArrayList<Territory> euterritories = new ArrayList<Territory>();
		euterritories.add(territorioprova);
		euterritories.add(territorioprova2);
		euterritories.add(territorioprova3);
		Continent eu = new Continent("Europa", euterritories);
		System.out.println(eu);
	}

}