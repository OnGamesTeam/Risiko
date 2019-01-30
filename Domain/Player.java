public class Player {

	private String ID;
	private String nickname;
	private String colour;
	private DiceShaker diceShaker;

	public Player(String playerID, String nickname, String colour){
		this.ID = playerID;
		this.nickname = nickname;
		this.colour = colour;
	}

	public String getID() {

		return this.ID;
	}

	/**
	 * 
	 * @param ID
	 */
	public void setID(String ID) {

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