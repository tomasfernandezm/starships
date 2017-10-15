package edu.austral.model.entities;

import edu.austral.model.Constants;
import edu.austral.model.Player;
import edu.austral.util.Collisionable;
import edu.austral.util.Vector2;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Shot extends Entity{

    private final float strength;
    private final Player author;

    public Shot(Vector2 position, Vector2 direction, Player author) {
        super(Constants.SHOT_LIFE, position, direction, Constants.SHOT_SPEED);
        this.shape = new Rectangle2D.Float(position.x(), position.y(), 20, 10);
        this.strength = Constants.SHOT_STRENGTH;
        this.author = author;

    }

    public void collisionedWith(Entity entity){

    }

    @Override
    public float getCollisionDamage() {
        return strength;
    }
}
