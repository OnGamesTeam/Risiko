package Domain;

import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "Result")
public class Result {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int ID;

	@OneToMany
	@JoinColumn(name = "ResultID")
	@Where(clause = "Die.type = 'Defense'")
	private List<Die> defDiceValue;

	@OneToMany
	@JoinColumn(name = "ResultID")
	@Where(clause = "Die.type = 'Attack'")
	private List<Die> atkDiceValue;

	@Column (name = "lostAttackingArmies")
	private int lostAttackingArmies;

	@Column (name = "lostDefendingArmies")
	private int lostDefendingArmies;

	@Column (name = "conqueredDefendingTerritory")
	private boolean conqueredDefendingTerritory;


	/**
	 *
	 * @return
	 */
	public List<Die> getAtkDiceValue() {
		return this.atkDiceValue;
	}

	/**
	 * 
	 * @param atkDiceValue
	 */
	public void setAtkDiceValue(ArrayList atkDiceValue) {
		this.atkDiceValue = atkDiceValue;
	}

	public List<Die> getDefDiceValue() {
		return this.defDiceValue;
	}

	/**
	 * 
	 * @param defDiceValue
	 */
	public void setDefDiceValue(ArrayList defDiceValue) {
		this.defDiceValue = defDiceValue;
	}

	public int getLostAttackingArmies() {
		return this.lostAttackingArmies;
	}

	/**
	 * 
	 * @param lostAttackingArmies
	 */
	public void setLostAttackingArmies(int lostAttackingArmies) {
		this.lostAttackingArmies = lostAttackingArmies;
	}

	public int getLostDefendingArmies() {
		return this.lostDefendingArmies;
	}

	/**
	 * 
	 * @param lostDefendingArmies
	 */
	public void setLostDefendingArmies(int lostDefendingArmies) {
		this.lostDefendingArmies = lostDefendingArmies;
	}

	public boolean getConqueredDefendingTerritory() {
		return this.conqueredDefendingTerritory;
	}

	/**
	 * 
	 * @param conqueredDefendingTerritory
	 */
	public void setConqueredDefendingTerritory(boolean conqueredDefendingTerritory) {
		this.conqueredDefendingTerritory = conqueredDefendingTerritory;
	}

	@Override
	public String toString() {
		return "AtkDiceValue: "+this.getAtkDiceValue() + " DefDiceValue: "+this.getDefDiceValue()+ " lostAtk: "+this.getLostAttackingArmies() + " lostDef: "+ this.getLostDefendingArmies() + " Conquered: "+this.getConqueredDefendingTerritory();
	}

	public int getID() {
		return this.ID;}

	/**
	 * 
	 * @param ID
	 */
	public void setID(int ID) {
		this.ID = ID;
	}

}