package edu.austral.model.entities;

import edu.austral.util.Collisionable;
import edu.austral.util.Vector2;

import java.awt.*;

public abstract class Entity implements Collisionable<Entity>{

    protected final Shape shape;
    protected Vector2 position;
    protected Vector2 direction;
    protected final float speed;
    protected double life;

    Entity(Shape shape, Vector2 position, Vector2 direction, float speed) {
        this.shape = shape;
        this.position = position;
        this.direction = direction;
        this.speed = speed;
    }

    public Shape getShape() {
        return shape;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Vector2 getDirection() {
        return direction;
    }

    public float getSpeed() {
        return speed;
    }

    public double getLife() {
        return life;
    }

    public void move(){
        position = position.$plus(direction.$times(speed));
    }

    public boolean isAlive(){
        return life > 0;
    }

    public void suffersDamage(int damage){
        life -= damage;
    }
}
