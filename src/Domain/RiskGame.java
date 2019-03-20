package Domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "RiskGame")
public class RiskGame {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int ID;

	@ManyToOne
	@JoinColumn(name = "MapId")
	private Map map;

	@OneToMany(mappedBy = "riskGame")
	private List<TerritoryStatus> territoryStatuses;

	@OneToMany(mappedBy = "riskGame")
	private List<RiskGame_Player> riskGame_players;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "RiskGameID")
	private List<Turn> turns;


	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public List<TerritoryStatus> getTerritoryStatuses() {
		return territoryStatuses;
	}

	public void setTerritoryStatuses(ArrayList<TerritoryStatus> territoryStatuses) {
		this.territoryStatuses = territoryStatuses;
	}

	public List<RiskGame_Player> getRiskGame_players() {
		return riskGame_players;
	}

	public void setRiskGame_players(ArrayList<RiskGame_Player> riskGame_players) {
		this.riskGame_players = riskGame_players;
	}

	public List<Turn> getTurns() {
		return turns;
	}

	public void setTurns(ArrayList<Turn> turns) {
		this.turns = turns;
	}
}