public class Player {

	private int ID;
	private String nickname;
	private String colour;
	DiceShaker diceShaker;

	public int getID() {

		return this.ID;
	}

	/**
	 * 
	 * @param ID
	 */
	public void setID(int ID) {

		this.ID = ID;
	}

	public String getNickname() {

		return this.nickname;
	}

	/**
	 * 
	 * @param nickname
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getColour() {
		return this.colour;
	}

	/**
	 * 
	 * @param colour
	 */
	public void setColour(String colour) {

		this.colour = colour;
	}

}