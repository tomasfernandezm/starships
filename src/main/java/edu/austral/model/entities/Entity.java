package edu.austral.model.entities;

import edu.austral.util.Collisionable;
import edu.austral.util.Vector2;

import java.awt.*;

public abstract class Entity implements Collisionable<Entity>{

    protected Shape shape;
    protected Vector2 position;
    protected Vector2 direction;
    protected final float speed;
    protected float life;

    Entity(float life, Vector2 position, Vector2 direction, float speed) {
        this.position = position;
        this.direction = direction;
        this.speed = speed;
        this.life = life;
    }

    @Override
    public void collisionedWith(Entity collisionable) {
        life -= collisionable.getCollisionDamage();
        // TODO make collision have consequences in the position and direction
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

    public abstract float getCollisionDamage();
}
