package edu.austral.model.entities;

import edu.austral.Constants;
import edu.austral.model.Player;
import edu.austral.util.Vector2;

import java.awt.geom.Rectangle2D;

public class Shot extends Entity{

    private final float strength;
    private final Player author;

    public Shot(Vector2 position, Vector2 direction, Player author) {
        super(Constants.SHOT_LIFE, position, direction, Constants.SHOT_SPEED, EntityEnum.SHOT);
        this.shape = new Rectangle2D.Float(position.x(), position.y(), Constants.SHOT_HEIGHT, Constants.SHOT_WIDTH);
        this.strength = Constants.SHOT_STRENGTH;
        this.author = author;
        this.life = 1;

    }

    public Player getPlayer(){
        return author;
    }

    @Override
    public void collisionedWith(Entity collisionable) {
        life -= collisionable.getCollisionDamage();
    }

    @Override
    public float getCollisionDamage() {
        return strength;
    }
}
