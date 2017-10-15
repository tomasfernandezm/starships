package edu.austral.model;

import edu.austral.model.entities.Entity;
import edu.austral.util.CollisionEngine;

import java.util.List;

public class Game {

    private static Game INSTANCE = new Game();

    public static Game getINSTANCE(){
        return INSTANCE;
    }

    private Game(){

    }

    private List<Player> playerList;
    private List<Entity> entities;
    private Map map = new Map(500, 500);
    private CollisionEngine collisionEngine;
    private Graveyard graveyard;

    public List<Player> getPlayerList() {
        return playerList;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public Map getMap() {
        return map;
    }

    public CollisionEngine getCollisionEngine() {
        return collisionEngine;
    }

    public Graveyard getGraveyard() {
        return graveyard;
    }
}
