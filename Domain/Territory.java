import java.util.ArrayList;

public class Territory {

	private String name;
	private TerritoryStatus territoryStatus;
	private ArrayList<Territory> neighbors;

	/**
	 *
	 * @param territoryName
	 */

	//costruttore da modificare
	public Territory(String territoryName){
		this.name = territoryName;
		this.territoryStatus = new TerritoryStatus();
		this.neighbors = new ArrayList<Territory>();
	}

	public void addNeighbor(Territory neighbor){
		this.neighbors.add(neighbor);
	}

	/**
	 * 
	 * @param playerID
	 */
	public boolean checkOwner(String playerID) {
		// TODO - implement Territory.checkOwner
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

	public TerritoryStatus getTerritoryStatus() {
		return territoryStatus;
	}

	public void setTerritoryStatus(TerritoryStatus territoryStatus) {
		this.territoryStatus = territoryStatus;
	}

	public ArrayList<Territory> getNeighbors(){
		return this.neighbors;
	}

	@Override
	public String toString() {
		return "name='" + name + '\'' + ", " + territoryStatus;
	}
}