package edu.austral.model;

import edu.austral.model.entities.Entity;
import edu.austral.util.Vector2;

public class Map {

    private final int xLength;
    private final int yLength;

    public Map(int xLength, int yLength) {
        this.xLength = xLength;
        this.yLength = yLength;
    }

    boolean canMove(Entity entity){
        Vector2 position = entity.getPosition().$plus(entity.getDirection().$times(entity.getSpeed()));
        return position.x() > xLength || position.y() > yLength;
    }
}
