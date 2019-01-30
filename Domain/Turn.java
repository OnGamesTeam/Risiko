public class Turn {

	CombatPhase CPhase;

	public void newCombatPhase() {
		this.CPhase = new CombatPhase();
	}

	public CombatPhase getCombatPhase() {
		return this.CPhase;
	}

}