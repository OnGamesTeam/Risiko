import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import  java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        //CONFUGURATION
        ArrayList<String> colours = new ArrayList<String>();
        colours.add("black");
        colours.add("blue");
        colours.add("red");
        colours.add("green");
        colours.add("yellow");
        colours.add("purple");

        ArrayList<String> playerNames = new ArrayList<String>();
        playerNames.add("bigfabbro");
        playerNames.add("livioski");
        playerNames.add("carlatt");
        playerNames.add("zar");

        HashMap<String, ArrayList<String>> territoryNamesNeighbors = new HashMap<>();
        ArrayList<String> neighbors = new ArrayList<>();
        neighbors.add("Germania");
        neighbors.add("Francia");
        territoryNamesNeighbors.put("Benelux", neighbors);

        neighbors = new ArrayList<String>();
        neighbors.add("Germania");
        neighbors.add("Svizzera");
        neighbors.add("Italia");
        territoryNamesNeighbors.put("Austria", neighbors);

        neighbors = new ArrayList<String>();
        neighbors.add("Spagna");
        territoryNamesNeighbors.put("Portogallo", neighbors);

        neighbors = new ArrayList<String>();
        neighbors.add("Italia");
        neighbors.add("Francia");
        neighbors.add("Germania");
        neighbors.add("Austria");
        territoryNamesNeighbors.put("Svizzera", neighbors);

        neighbors = new ArrayList<String>();
        neighbors.add("Germania");
        territoryNamesNeighbors.put("Danimarca", neighbors);

        neighbors = new ArrayList<String>();
        neighbors.add("Francia");
        neighbors.add("Svizzera");
        neighbors.add("Austria");
        territoryNamesNeighbors.put("Italia", neighbors);

        neighbors = new ArrayList<String>();
        neighbors.add("Francia");
        neighbors.add("Portogallo");
        territoryNamesNeighbors.put("Spagna", neighbors);

        neighbors = new ArrayList<String>();
        neighbors.add("Svizzera");
        neighbors.add("Francia");
        neighbors.add("Benelux");
        neighbors.add("Danimarca");
        neighbors.add("Austria");
        territoryNamesNeighbors.put("Germania", neighbors);

        neighbors = new ArrayList<String>();
        neighbors.add("Italia");
        neighbors.add("Svizzera");
        neighbors.add("Germania");
        neighbors.add("Benelux");
        neighbors.add("Spagna");
        territoryNamesNeighbors.put("Francia", neighbors);
        //END CONFIGURATION


        ArrayList<Territory> euterritories = new ArrayList<Territory>();
        ArrayList<Player> players = new ArrayList<Player>();
        Random rand = new Random();

        //Territories' creation
        territoryNamesNeighbors.forEach((territoryName, neighs) -> {
            Territory territory = new Territory(territoryName);
            territory.setArmies(4);
            euterritories.add(territory);
        });


        Continent eu = new Continent("Europa", euterritories);

        //Players' creation colour assign
        for (String player :
                playerNames) {
            int indColour = rand.nextInt(colours.size());
            players.add(new Player(player, player, colours.get(indColour)));
            colours.remove(indColour);
        }

        //Assign Owner to Territory
        int i = 0;
        for (Territory territory :
                eu.getTerritories()) {
            territory.setOwner(players.get(i));
            i = (i + 1) % players.size();
        }


        Map map = new Map();
        ArrayList<Continent> continents = new ArrayList<Continent>();
        continents.add(eu);
        map.setContinents(continents);

        //Impostazione dei vicini
        territoryNamesNeighbors.forEach((territoryName, neighs) -> {
            Territory territory = map.getTerritorybyName(territoryName);
            for (String neighName :
                    neighs) {
                territory.addNeighbor(map.getTerritorybyName(neighName));
            }
        });

        //Inizio Gioco
        boolean play = true;
        Turn currentTurn = new Turn ();
        ClassicAttackRules atkRules = new ClassicAttackRules();
        CombatPhaseHandler CPH = new CombatPhaseHandler(currentTurn, atkRules, map);
        CPH.startCombatPhase();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Questi sono i giocatori: ");
        for(int j = 0; j<players.size(); j++){
            System.out.print(players.get(j).getID() +" ");
        }
        System.out.println("Scegli il tuo giocatore: ");
        String myPlayer = keyboard.next();
        while(CPH.showAttackingTerritories(myPlayer).size()>0) {
            System.out.println("I tuoi territori: ");
            System.out.println(map.getPlayerTerritories(myPlayer));
            System.out.println("Territori dai quali puoi muovere un attacco: ");
            System.out.println(CPH.showAttackingTerritories(myPlayer));
            System.out.println("Inserisci territorio dal quale vuoi muovere un attacco: ");
            String atkTerritoryName = keyboard.next();
            System.out.println("Territori attaccabili da " + atkTerritoryName + " : \n" + CPH.showAttackableTerritories(atkTerritoryName));
            System.out.println("Inserisci territorio da attaccare: ");
            String defTerritoryName = keyboard.next();
            System.out.println("Inserisci numero di armate con il quale attaccare: ");
            int atkArmies = keyboard.nextInt();
            CPH.makeAttack(atkTerritoryName, defTerritoryName, atkArmies);
            int defArmies = map.getTerritorybyName(defTerritoryName).getArmies();
            while(!(CPH.setDefendingArmiesNumber(defArmies))) {
                System.out.print("inserisci un numero valido\n");
                defArmies = keyboard.nextInt();
            }

            System.out.println("Il difensore ha utilizzato "+defArmies+" armate");
            System.out.println(CPH.calculateAttackResult());
        }
    }
}
