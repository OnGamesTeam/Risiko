import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table (name = "Result")
public class Result {

	/*
	da testare, POTREBBERO ESSERCI PROBLEMI
	 */
	@OneToMany
	@JoinColumn(name = "Die")
	@Where(clause = "type = 'Attacker'")
	private ArrayList<Integer> atkDiceValue;

	/*
	da testare, POTREBBERO ESSERCI PROBLEMI
	 */
	@OneToMany
	@JoinColumn(name = "Die")
	@Where(clause = "type = 'Defender'")
	private ArrayList<Integer> defDiceValue;


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
	public ArrayList getAtkDiceValue() {
		return this.atkDiceValue;
	}

	/**
	 * 
	 * @param atkDiceValue
	 */
	public void setAtkDiceValue(ArrayList atkDiceValue) {
		this.atkDiceValue = atkDiceValue;
	}

	public ArrayList getDefDiceValue() {
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

}