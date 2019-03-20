package Foundation;

import Domain.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class PersistantManager {

    private static PersistantManager instance;
    private SessionFactory sessionFactory;

    private PersistantManager(){
        this.sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Attack.class)
                .addAnnotatedClass(CombatPhase.class)
                .addAnnotatedClass(Map.class)
                .addAnnotatedClass(Continent.class)
                .addAnnotatedClass(Territory.class)
                .addAnnotatedClass(Player.class)
                .addAnnotatedClass(RiskGame.class)
                .addAnnotatedClass(RiskGame_Player.class)
                .addAnnotatedClass(Die.class)
                .addAnnotatedClass(Result.class)
                .addAnnotatedClass(TerritoryStatus.class)
                .addAnnotatedClass(Turn.class)
                .buildSessionFactory();
    }

    static public PersistantManager getInstance(){
        if(instance == null){
            instance = new PersistantManager();
        }
        return instance;
    }

    public SessionFactory getSessionFactory(){
        return this.sessionFactory;
    }
}
