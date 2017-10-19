package edu.austral.model.entities;

import edu.austral.model.entities.weapons.StandardWeapon;
import edu.austral.model.entities.weapons.Weapon;
import edu.austral.util.Vector2;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class FWeapon extends Entity {

    private Weapon weapon;
    private final float collisionDamage;

    public FWeapon(float life, Vector2 position, Vector2 direction, float speed) {
        super(life, position, direction, speed, EntityEnum.FWEAPON);
        this.shape = new Rectangle2D.Float(position.x(), position.y(), 30, 30);
        collisionDamage = (float) life/10;
        weapon = new StandardWeapon();
    }

    @Override
    public float getCollisionDamage() {
        return collisionDamage;
    }

    @Override
    public void collisionedWith(Entity collisionable) {
        if(collisionable.getType().equals(EntityEnum.STARSHIP)) life = -1;
        else super.collisionedWith(collisionable);
    }

    public Weapon getWeapon() {
        return weapon;
    }
}
