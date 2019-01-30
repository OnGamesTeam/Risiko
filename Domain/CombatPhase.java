import java.util.*;

public class CombatPhase {

	ArrayList<Attack> attacks;

	public CombatPhase(){
		this.attacks = new ArrayList<Attack>();
		this.startTimer();
	}

	public boolean startTimer() {

		// TODO - implement CombatPhase.startTimer
		return  true; //da eliminare
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

}