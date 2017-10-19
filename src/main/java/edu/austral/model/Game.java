package edu.austral.model;

import edu.austral.model.entities.Entity;
import edu.austral.model.entities.EntityEnum;
import edu.austral.util.CollisionEngine;
import edu.austral.view.View;
import scala.collection.JavaConverters;

import java.util.ArrayList;
import java.util.List;

import static edu.austral.model.entities.EntityEnum.FWEAPON;
import static edu.austral.model.entities.EntityEnum.STARSHIP;

public class Game {

    public View view;
    private List<Entity> entities = new ArrayList<>();
    private Map map = new Map(500, 500);
    private CollisionEngine<Entity> collisionEngine = new CollisionEngine<>();
    private Graveyard graveyard = new Graveyard();

    private static Game INSTANCE = new Game();
    public static Game getINSTANCE(){
        return INSTANCE;
    }

    private Game(){ }

    public void iterate(){
        moveEntities();
        checkCollisions();
        sendToGraveyard();
        removeGraveyardEntitiesFromGame();
        graveyard.empty();
    }

    private void moveEntities(){
        for(Entity e: entities){
            if(!e.getType().equals(STARSHIP))e.move();
        }
    }

    private void checkCollisions(){
        collisionEngine.checkCollisions(JavaConverters.asScalaBuffer(entities));
    }

    private void sendToGraveyard(){
        for(Entity e: entities){
            if(!e.isAlive() || !map.isInMap(e.getPosition())) graveyard.addToGraveyard(e);
        }
    }

    private void removeGraveyardEntitiesFromGame(){
        for(Entity e: graveyard.getEntities()){
            view.remove(e);
            entities.remove(e);
        }
    }

    public void addEntity(Entity e) {
        entities.add(e);
    }

    public void addView(View view){
        this.view = view;
    }

    public Map getMap() {
        return map;
    }
}
