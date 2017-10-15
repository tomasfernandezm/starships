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

    public boolean isInMap(Vector2 vector){
        boolean moveInX = vector.x() < xLength && vector.x() > 0;
        boolean moveInY = vector.y() < yLength && vector.y() > 0;
        return moveInX && moveInY;
    }

    public boolean canMoveForward(Entity entity){
        return canMove(entity, 1);
    }

    public boolean canMoveBackwards(Entity entity){
        return canMove(entity, -1);
    }

    private boolean canMove(Entity entity, int direction){
        Vector2 position = entity.getPosition().$plus(entity.getDirection().$times(entity.getSpeed()*direction));
        return isInMap(position);
    }
}
