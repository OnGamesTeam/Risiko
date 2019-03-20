package Domain;

import javax.persistence.*;

@Entity
@Table(name = "RiskGame_Player")
public class RiskGame_Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;


    // Join con le due tabelle: Domain.RiskGame e Domain.Player
    @ManyToOne
    @JoinColumn(name = "RiskGameID")
    private RiskGame riskGame;

    @ManyToOne
    @JoinColumn(name = "PlayerID")
    private Player player;

    // campi aggiuntivi --> campi relativi alla specifica coppia di istanze Domain.RiskGame - Domain.Player
    private String colour;

    public RiskGame getRiskGame() {
        return riskGame;
    }

    public void setRiskGame(RiskGame riskGame) {
        this.riskGame = riskGame;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "RiskGame_Player{" +
                "ID=" + ID +
                ", riskGame=" + riskGame +
                ", player=" + player +
                ", colour='" + colour + '\'' +
                '}';
    }
}
