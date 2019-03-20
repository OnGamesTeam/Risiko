package Domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Territory")
public class Territory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int ID;

	@Column(name = "name")
	private String name;

	@OneToOne(mappedBy = "territory")
	private TerritoryStatus territoryStatus;

	@ManyToMany
	@JoinTable(
			name= "TerritoryNeighbors",
			joinColumns = @JoinColumn(name = "TerritoryID"),
			inverseJoinColumns = @JoinColumn(name = "NeighborID")
	)
	private List<Territory> neighbors;

	@ManyToMany
	@JoinTable(
			name = "TerritoryNeighbors",
			joinColumns = @JoinColumn(name = "NeighborID"),
			inverseJoinColumns = @JoinColumn(name = "TerritoryID")
	)
	private List<Territory> neighborOf;

	/**
	 *
	 * @param territoryName
	 */


	public Territory(){};

	//costruttore da modificare
	public Territory(String territoryName){
		this.name = territoryName;
		this.territoryStatus = new TerritoryStatus();
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
		// TODO - implement Domain.Territory.checkOwner
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

	public TerritoryStatus getTerritoryStatus() {
		return territoryStatus;
	}

	public void setTerritoryStatus(TerritoryStatus territoryStatus) {
		this.territoryStatus = territoryStatus;
	}

	public List<Territory> getNeighbors(){
		return this.neighbors;
	}

	@Override
	public String toString() {
		return "name='" + name + '\'' + ", " + territoryStatus;
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