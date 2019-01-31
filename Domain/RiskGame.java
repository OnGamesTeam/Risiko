import java.util.ArrayList;

public class RiskGame {

	private Map map;

	//singleton
	static private RiskGame Instance = null;

	private RiskGame() {}

	static public RiskGame getInstance()
	{
		if (Instance == null)
			Instance = new RiskGame();
		return RiskGame.Instance;
	}
	//end singleton

	public Map getMap() {
		return this.map;
	}

	/**
	 * 
	 * @param map
	 */
	public void setMap(Map map) {
		this.map = map;
	}
}