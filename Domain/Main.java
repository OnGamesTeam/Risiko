import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Player faber = new Player("ABCD", "bigfabbro", "red");
        Player carlo = new Player ("EFGH", "calatt", "blue");
        Territory territorioprova = new Territory("Italia");
        territorioprova.setOwner(faber);
        territorioprova.setArmies(1);
        Territory territorioprova2 = new Territory("Francia");
        territorioprova2.setOwner(faber);
        territorioprova2.setArmies(2);
        Territory territorioprova3 = new Territory("Svizzera");
        territorioprova3.setOwner(carlo);
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
        Map m = new Map();
        m.setContinents(continents);
        ClassicAttackRules rules = new ClassicAttackRules();
        System.out.println(m.getAttackingTerritory(faber.getID(), rules));
        System.out.println(m.getAttackableTerritories("Francia", rules));
    }
}
