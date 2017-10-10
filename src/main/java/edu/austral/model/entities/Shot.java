package edu.austral.model.entities;

import edu.austral.model.Player;
import edu.austral.util.Collisionable;
import edu.austral.util.Vector2;

import java.awt.*;

public class Shot extends Entity{

    private final float strength;
    private final float size;
    private final Player author;

    public Shot(Shape shape, Vector2 position, Vector2 direction, float speed, float strength, float size, Player author) {
        super(shape, position, direction, speed);
        this.strength = strength;
        this.size = size;
        this.author = author;
    }

    @Override
    public void collisionedWith(Entity collisionable) {

    }
}
