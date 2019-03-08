public class TerritoryStatus {

	private Player owner;
	private int armies;

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

	@Override
	public String toString() {
		return "armies=" + armies ;
	}
}