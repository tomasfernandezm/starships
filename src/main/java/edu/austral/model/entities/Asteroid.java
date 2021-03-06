package edu.austral.model.entities;

import edu.austral.util.Vector2;

import java.awt.geom.Ellipse2D;

public class Asteroid extends Entity {

    private final float size;

    public Asteroid(Vector2 position, Vector2 direction, float speed, float size) {
        super((int) size, position, direction, speed, EntityEnum.ASTEROID);
        this.shape = new Ellipse2D.Float(position.x()-size/2, position.y()-size/2, size, size);
        this.size = size;
    }

    @Override
    public void collisionedWith(Entity collisionable) {
        if(!collisionable.getType().equals(EntityEnum.ASTEROID)) super.collisionedWith(collisionable);
        else direction = direction.$times(-1);
    }

    @Override
    public float getCollisionDamage() {
        return size;
    }
}
