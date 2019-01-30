import java.util.ArrayList;

public class RiskGame {

	private Map map;

	//singleton
	static private RiskGame Instance = null;

	private RiskGame() {

		//AL MOMENTO DELLA CREAZIONE VIENE CREATA UNA MAPPA SEMPLICE
		//TUTTO CIÒ CHE È ALL'INTERNO DI QUESTO METODO È PROVVISORIO
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
		ArrayList<Continent> continents = new ArrayList<Continent>();
		this.map.setContinents(continents);
	}

	static public RiskGame getInstance()
	{
		if (Instance != null)
			return Instance;
		else
		{
			Instance = new RiskGame();
			return Instance;
		}
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