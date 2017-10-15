package edu.austral.model.entities;

import edu.austral.util.Vector2;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Asteroid extends Entity {

    private final float size;

    Asteroid(float life, Vector2 position, Vector2 direction, float speed, float size) {
        super(life, position, direction, speed);
        this.shape = new Ellipse2D.Float(position.x(), position.y(), size, size);
        this.size = size;
    }

    public float getSize() {
        return size;
    }

    @Override
    public float getCollisionDamage() {
        return size;
    }
}
