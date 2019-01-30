import java.util.*;

public class Continent {

	ArrayList<Territory> territories;
	private String name;

	//costruttore da modificare
	public Continent(String continentName, ArrayList<Territory> continentTerritories){
		this.name = continentName;
		this.territories = continentTerritories;
	}


	public List<Territory> getTerritories() {
		// TODO - implement Continent.getTerritories
		throw new UnsupportedOperationException();
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