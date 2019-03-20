package Domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Continent")
public class Continent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int ID;

	@Column(name = "name")
	private String name;

	@OneToMany
	@JoinColumn(name = "ContinentID")
	private List<Territory> territories;


	public Continent(){};

	//costruttore da modificare
	public Continent(String continentName, ArrayList<Territory> continentTerritories){
		this.name = continentName;
		this.territories = continentTerritories;
	}


	public List<Territory> getTerritories() {
		return this.territories;
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

	/**
	 * 
	 * @param territories
	 */
	public void setTerritories(ArrayList territories) {
		this.territories = territories;
	}

	@Override
	public String toString() {
		return "Name: "+ this.name+" Territories: "+territories;
	}

	public int getID() {
		// TODO - implement Domain.Continent.getID
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ID
	 */
	public void setID(int ID) {
		// TODO - implement Domain.Continent.setID
		throw new UnsupportedOperationException();
	}

}

