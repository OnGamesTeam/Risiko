package Domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Player")
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private String ID;

	@Column(name = "nickname")
	private String nickname;

	@OneToMany(mappedBy = "player")
	private List<RiskGame_Player> riskGame_players;

	@Transient
	private DiceShaker diceShaker;

	public Player(String playerID, String nickname){
		this.ID = playerID;
		this.nickname = nickname;
	}

	public Player(){}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getNickname() {

		return this.nickname;
	}

	/**
	 * 
	 * @param nickname
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return
				"[ID='" + ID + '\'' +
				", nickname='" + nickname + ']'+'\'';
	}
}