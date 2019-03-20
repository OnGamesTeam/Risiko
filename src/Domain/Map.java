package Domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Map")
public class Map {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int ID;

	@Column(name = "name")
	private String name;

	@OneToMany
	@JoinColumn(name = "MapID")
	private List<Continent> continents;


	//costruttore da modificare
	public void setContinents(ArrayList<Continent> continents){
		this.continents = continents;
	}
	/**
	 * DA RIFARE QUANDO È INTEGRATO IL DB
	 * @param playerID
	 */

	public List<Territory> getPlayerTerritories(String playerID) {
		ArrayList<Territory> playerTerritories = new ArrayList<Territory>();
		for(int i = 0; i<this.continents.size(); i++){
			Continent currentContinent = this.continents.get(i);
			List<Territory> currentTerritories = currentContinent.getTerritories();
			for(int j = 0; j<currentTerritories.size(); j ++){
				Player currentPlayer = currentTerritories.get(j).getTerritoryStatus().getOwner();
				if(playerID.equals(currentPlayer.getID())){
					playerTerritories.add(currentTerritories.get(j));
				}
			}
		}
		return playerTerritories;
	}

	/**
	 * DA RIFARE QUANDO È INTEGRATO IL DB
	 * @param territoryName
	 */
	public Territory getTerritorybyName(String territoryName) {
		/** IMPLEMENTAZIONE DI PROVA**/

		for (Continent continent:
			 this.continents) {
			for (Territory territory:
				 continent.getTerritories()) {
				if (territory.getName().equals(territoryName))
					return territory;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param playerID
	 * @param atkRule
	 */
	public List<Territory> getAttackingTerritory(String playerID, AttackRule atkRule) {
		return atkRule.calculateAttackingTerritory(this, playerID);
	}

	/**
	 * 
	 * @param nameAttackingTerritory
	 * @param atkRule
	 */
	public List<Territory> getAttackableTerritories(String nameAttackingTerritory, AttackRule atkRule) {
		return atkRule.calculateAttackableTerritory(this, nameAttackingTerritory);
	}

    @Override
    public String toString() {
        return "Domain.Map{" + "Name: " + this.name +
                " continents=" + continents +
                '}';
    }

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

}