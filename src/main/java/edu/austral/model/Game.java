package edu.austral.model;

import edu.austral.model.calculators.ScoreCalculator;
import edu.austral.model.collision.CollisionEngine;
import edu.austral.model.entities.Entity;

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
    private Map map;
    private CollisionEngine collisionEngine;
    private ScoreCalculator scoreCalculator;
    private Graveyard graveyard;


}
