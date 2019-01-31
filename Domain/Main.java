import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Player faber = new Player("ABCD", "bigfabbro", "red");
        Player carlo = new Player ("EFGH", "calatt", "blue");
        Territory territorioprova = new Territory("Italia");
        territorioprova.setOwner(faber);
        territorioprova.setArmies(4);
        Territory territorioprova2 = new Territory("Francia");
        territorioprova2.setOwner(faber);
        territorioprova2.setArmies(2);
        Territory territorioprova3 = new Territory("Svizzera");
        territorioprova3.setOwner(carlo);
        territorioprova3.setArmies(3);
        territorioprova.addNeighbor(territorioprova2);
        territorioprova.addNeighbor(territorioprova3);
        territorioprova2.addNeighbor(territorioprova);
        territorioprova2.addNeighbor(territorioprova3);
        ArrayList<Territory> euterritories = new ArrayList<Territory>();
        euterritories.add(territorioprova);
        euterritories.add(territorioprova2);
        euterritories.add(territorioprova3);
        Continent eu = new Continent("Europa", euterritories);
        ArrayList<Continent> continents = new ArrayList<Continent>();
        continents.add(eu);
        System.out.println(eu);
        // Mappa
        Map m = new Map();
        m.setContinents(continents);
        ClassicAttackRules rules = new ClassicAttackRules();
        ArrayList<Territory> atkterritories = rules.calculateAttackingTerritory(m, "ABCD");
        System.out.println(atkterritories);
        //test e creazione di combat phase handler
        CombatPhaseHandler cpHandler = new CombatPhaseHandler(new Turn(new CombatPhase()),new ClassicAttackRules(), m);
        System.out.print(cpHandler.makeAttack("Francia", "Svizzera", 1));
        Attack newAttack = new Attack();
        newAttack.setAttackingTerritory(territorioprova);
        newAttack.setDefendingTerritory(territorioprova3);
        newAttack.setAttackingArmiesNumber(3);
        newAttack.setDefendingArmiesNumber(3);
        rules.calculateAttackResult(newAttack);
        System.out.println(newAttack);
    }
}