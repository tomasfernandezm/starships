package edu.austral.model.entities;

import edu.austral.util.Collisionable;
import edu.austral.util.Vector2;

import java.awt.*;
import java.awt.geom.AffineTransform;

import static edu.austral.model.entities.EntityEnum.SHOT;

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
        position = position.$plus(direction.$times(speed));
        moveShape();
    }

    public void moveShape(){
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.setToIdentity();
        affineTransform.translate(direction.x()*speed, direction.y()*speed);
        shape = affineTransform.createTransformedShape(shape).getBounds2D();
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
