import java.util.*;
public class Turn {

	private CombatPhase CPhase;

	public void newCombatPhase() {
		this.CPhase = new CombatPhase();
	}

	public CombatPhase getCombatPhase() {
		return this.CPhase;
	}

}