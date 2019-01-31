import java.util.*;
public class Turn {

	private CombatPhase CPhase;

	//costruttore temporaneo
	public Turn(CombatPhase CPhase) {
		this.CPhase = CPhase;
	}

	public void newCombatPhase() {
		this.CPhase = new CombatPhase();
	}

	public CombatPhase getCombatPhase() {
		return this.CPhase;
	}

}