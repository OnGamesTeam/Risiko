package Domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TerritoryStatusID implements Serializable {

    @Column(name = "TerritoryID")
    private Long territoryID;

    @Column(name = "RiskGameID")
    private Long riskGameID;

    public TerritoryStatusID(){}

    public TerritoryStatusID(Long terrID, Long rkID){
        this.territoryID = terrID;
        this.riskGameID = rkID;
    }

    public Long getTerritoryID() {
        return territoryID;
    }

    public void setTerritoryID(Long territoryID) {
        this.territoryID = territoryID;
    }

    public Long getRiskGameID() {
        return riskGameID;
    }

    public void setRiskGameID(Long riskGameID) {
        this.riskGameID = riskGameID;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof TerritoryStatusID)) return false;
        TerritoryStatusID that = (TerritoryStatusID) o;
        return Objects.equals(getTerritoryID(), that.getTerritoryID()) && Objects.equals(getRiskGameID(),that.getRiskGameID());
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.getRiskGameID(),this.getTerritoryID());
    }


}
