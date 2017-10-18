package edu.austral.model.entities;

import edu.austral.util.Collisionable;
import edu.austral.util.Vector2;

import java.awt.*;

public abstract class Entity implements Collisionable<Entity>{

    Shape shape;
    Vector2 position;
    Vector2 direction;
    float directionAngle = 0;
    final float speed;
    float life;
    private EntityEnum type;

    Entity(float life, Vector2 position, Vector2 direction, float speed, EntityEnum type) {
        this.position = position;
        this.direction = direction;
        this.speed = speed;
        this.life = life;
        this.type = type;
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

    public void move(){
        position = position.$plus(direction.$times(speed));
    }

    public boolean isAlive(){
        return life > 0;
    }

    public abstract float getCollisionDamage();

    public float getDirectionAngle() {
        return directionAngle;
    }

    public EntityEnum getType() {
        return type;
    }
}
