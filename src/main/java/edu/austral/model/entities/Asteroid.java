package edu.austral.model.entities;

import edu.austral.util.Vector2;

import java.awt.*;

public class Asteroid extends Entity {

    private final float size;

    public Asteroid(Shape shape, Vector2 position, Vector2 direction, float speed, float size) {
        super(shape, position, direction, speed);
        this.size = size;
    }

    public float getSize() {
        return size;
    }

    @Override
    public void collisionedWith(Entity collisionable) {
        // TODO implement collisionedWith
    }
}
