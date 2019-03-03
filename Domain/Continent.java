import java.util.*;

public class Continent {

	private ArrayList<Territory> territories;
	private String name;
	Collection<Territory> territory;

	//costruttore da modificare
	public Continent(String continentName, ArrayList<Territory> continentTerritories){
		this.name = continentName;
		this.territories = continentTerritories;
	}


	public ArrayList<Territory> getTerritories() {
		return this.territories;
	}

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @param territories
	 */
	public void setTerritories(ArrayList territories) {
		// TODO - implement Continent.setTerritories
		throw new UnsupportedOperationException();
	}

	@Override
	public String toString() {
		return "Name: "+ this.name+" Territories: "+territories;
	}

}

