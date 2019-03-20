package Domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CombatPhase")
public class CombatPhase {

	@Id
	@Column(name = "ID")
	private int ID;

	@OneToMany
	@JoinColumn(name = "CombatPhaseID")
	private List<Attack> attacks;

	public CombatPhase(){
		this.attacks = new ArrayList<Attack>();
		this.startTimer();
	}

	public boolean startTimer() {
              /**IMPLEMENTARE**/
	return true;
	}

	/**
	 * 
	 * @param atkTerritory
	 * @param defTerritory
	 * @param attackingArmiesNumber
	 */
	public void makeNewAttack(Territory atkTerritory, Territory defTerritory, int attackingArmiesNumber) {
		Attack attack = new Attack();
		attack.setAttackingTerritory(atkTerritory);
		attack.setDefendingTerritory(defTerritory);
		attack.setAttackingArmiesNumber(attackingArmiesNumber);
		this.attacks.add(attack);
	}

	public Attack getCurrentAttack() {
		int atkNumber = this.attacks.size();
		return this.attacks.get(atkNumber-1);
	}

	public int getID() {
		// TODO - implement Domain.CombatPhase.getID
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ID
	 */
	public void setID(int ID) {
		// TODO - implement Domain.CombatPhase.setID
		throw new UnsupportedOperationException();
	}

}