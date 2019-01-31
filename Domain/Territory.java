import java.util.ArrayList;

public class Territory {

	private String name;
	private int armies;
	private Player owner;
	private ArrayList<Territory> neighbors;

	/**
	 *
	 * @param territoryName
	 */

	//costruttore da modificare
	public Territory(String territoryName){
		this.name = territoryName;
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

	public int getArmies() {
		return this.armies;
	}

	/**
	 * 
	 * @param armies
	 */
	public void setArmies(int armies) {
		this.armies = armies;
	}

	public Player getOwner() {
		return this.owner;
	}

	/**
	 * 
	 * @param owner
	 */
	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public ArrayList<Territory> getNeighbors(){
		return this.neighbors;
	}

	@Override
	public String toString() {
		return "Name: "+this.getName() + " Armies: "+this.getArmies();
	}
}