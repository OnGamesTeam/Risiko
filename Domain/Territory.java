public class Territory {

	private String name;
	private int armies;
	Player owner;

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

}