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

import static edu.austral.model.entities.EntityEnum.SHOT;
import static edu.austral.model.entities.EntityEnum.STARSHIP;

public abstract class Entity implements Collisionable<Entity>{

    Shape shape;
    Vector2 position;
    Vector2 direction;
    float directionAngle = 0;
    final float speed;
    public int life;
    private EntityEnum type;

    Entity(int life, Vector2 position, Vector2 direction, float speed, EntityEnum type) {
        this.position = position;
        this.direction = direction;
        this.speed = speed;
        this.life = life;
        this.type = type;
    }

    @Override
    public void collisionedWith(Entity collisionable) {
        life -= collisionable.getCollisionDamage();
        if(life < 0){
            life = 0;
            if(collisionable.getType().equals(SHOT)){
                Shot shot = (Shot) collisionable;
                shot.getPlayer().addToScore((int) getCollisionDamage());
            }
        }
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
        if(this.getType().equals(STARSHIP)){
            System.out.println("AAAA");
        }
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.setToIdentity();
        position = position.$plus(direction.$times(speed));
        affineTransform.translate(direction.x()*speed, direction.y()*speed);
        shape = affineTransform.createTransformedShape(shape).getBounds2D();
        if(this.getType().equals(STARSHIP)){
            System.out.println(shape.getBounds().x + " | " + shape.getBounds().y);
        }
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
