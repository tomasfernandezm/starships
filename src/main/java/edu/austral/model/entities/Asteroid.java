package edu.austral.model.entities;

import edu.austral.util.Vector2;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Asteroid extends Entity {

    private final float size;

    public Asteroid(Vector2 position, Vector2 direction, float speed, float size) {
        super(size, position, direction, speed, EntityEnum.ASTEROID);
        this.shape = new Ellipse2D.Float(position.x(), position.y(), size, size);
        this.size = size;
    }

    public float getSize() {
        return size;
    }

    @Override
    public void collisionedWith(Entity collisionable) {
        if(!collisionable.getType().equals(EntityEnum.ASTEROID)) super.collisionedWith(collisionable);
    }

    @Override
    public float getCollisionDamage() {
        return size;
    }
}
