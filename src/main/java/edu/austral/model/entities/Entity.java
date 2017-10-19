package edu.austral.model.entities;

import edu.austral.model.EntityObserver;
import edu.austral.model.Observable;
import edu.austral.util.Collisionable;
import edu.austral.util.Vector2;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public abstract class Entity implements Collisionable<Entity>, Observable{

    Shape shape;
    Vector2 position;
    Vector2 direction;
    float directionAngle = 0;
    final float speed;
    float life;
    private EntityEnum type;
    private List<EntityObserver> observerList = new ArrayList<>();

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
        if(!isAlive()) for(EntityObserver e: observerList) e.notify(this);
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

        AffineTransform affineTransform = new AffineTransform();
        position = position.$plus(direction.$times(speed));
        affineTransform.translate(direction.x()*speed, direction.y()*speed);
        shape = affineTransform.createTransformedShape(shape);

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

    @Override
    public void addObserver(EntityObserver eo) {
        observerList.add(eo);
    }

    @Override
    public void deleteObserver(EntityObserver eo) {
        observerList.remove(eo);
    }

    @Override
    public void deleteObservers() {
        observerList.clear();
    }
}
