package Domain;

import javax.persistence.*;

@Entity
@Table(name = "Attack")
public class Attack {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int ID;

	@Column(name = "attackingArmiesNumber")
	private int attackingArmiesNumber;

	@Column(name = "defendingArmiesNumber")
	private int defendingArmiesNumber;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ResultID")
	private Result attackResult;

	@ManyToOne
	@JoinColumn(name = "attackingTerritoryID")
	private Territory attackingTerritory;

	@ManyToOne
	@JoinColumn(name = "defendingTerritoryID")
	private Territory defendingTerritory;



	public Result getResult() {
		return this.attackResult;
	}

	public Territory getAttackingTerritory() {
		return this.attackingTerritory;
	}

	/**
	 * 
	 * @param attackingTerritory
	 */
	public void setAttackingTerritory(Territory attackingTerritory) {
		this.attackingTerritory = attackingTerritory;
	}

	public Territory getDefendingTerritory() {
		return this.defendingTerritory;
	}

	/**
	 * 
	 * @param defendingTerritory
	 */
	public void setDefendingTerritory(Territory defendingTerritory) {
		this.defendingTerritory = defendingTerritory;
	}

	/**
	 * 
	 * @param atkRules
	 */
	public Result getAttackResult(AttackRule atkRules){
		atkRules.calculateAttackResult(this);
		return this.getResult();
	}

	/**
	 * 
	 * @param attackResult
	 */
	public void setAttackResult(Result attackResult) {
		this.attackResult = attackResult;
	}

	public int getAttackingArmiesNumber() {
		return attackingArmiesNumber;
	}

	/**
	 * 
	 * @param attackingArmiesNumber
	 */
	public void setAttackingArmiesNumber(int attackingArmiesNumber) {
		this.attackingArmiesNumber = attackingArmiesNumber;
	}

	public int getDefendingArmiesNumber() {
		return defendingArmiesNumber;
	}

	/**
	 * 
	 * @param defendingArmiesNumber
	 */
	public void setDefendingArmiesNumber(int defendingArmiesNumber) {
		this.defendingArmiesNumber = defendingArmiesNumber;
	}

	@Override
	public String toString() {
		return "Atk: " + this.getAttackingTerritory() + " AtkArmies: " + this.getAttackingArmiesNumber() + " Def: " + this.getDefendingTerritory() + " DefArmies: " + this.getDefendingArmiesNumber() + " Domain.Result: " + this.getResult();
	}

	public int getID() {
		// TODO - implement Domain.Attack.getID
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ID
	 */
	public void setID(int ID) {
		// TODO - implement Domain.Attack.setID
		throw new UnsupportedOperationException();
	}


}