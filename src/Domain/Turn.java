package Domain;

import javax.persistence.*;

@Entity
@Table(name = "Turn")
public class Turn {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int ID;

	@OneToOne
	@JoinColumn(name = "CombatPhaseID")
	private CombatPhase CPhase;



	public void newCombatPhase() {
		this.CPhase = new CombatPhase();
	}

	public CombatPhase getCombatPhase() {
		return this.CPhase;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}
}