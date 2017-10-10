package edu.austral.model;

import edu.austral.model.entities.Entity;

import java.util.ArrayList;
import java.util.List;

public class Graveyard {

    private List<Entity> entities = new ArrayList<>();
    private int amount = 0;

    public void addToGraveyard(Entity entity){
        entities.add(entity);
        amount++;
    }
}
