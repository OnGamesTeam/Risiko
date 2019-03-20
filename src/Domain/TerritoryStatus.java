package Domain;

import javax.persistence.*;

@Entity
@Table(name = "TerritoryStatus")
public class TerritoryStatus {

	@EmbeddedId
	private TerritoryStatusID ID;

	@ManyToOne
	@JoinColumn(name = "RiskGameID", insertable = false, updatable = false)
	private RiskGame riskGame;

	@ManyToOne
	@JoinColumn(name = "TerritoryID",  insertable = false, updatable = false)
	private Territory territory;

	@ManyToOne
	@JoinColumn(name = "PlayerID")
	private Player owner;
	private int armies;

	public RiskGame getRiskGame() {
		return riskGame;
	}


	public TerritoryStatusID getID() {
		return ID;
	}

	public void setID(TerritoryStatusID ID) {
		this.ID = ID;
	}

	public void setRiskGame(RiskGame riskGame) {
		this.riskGame = riskGame;
	}

	public Territory getTerritory() {
		return territory;
	}

	public void setTerritory(Territory territory) {
		this.territory = territory;
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